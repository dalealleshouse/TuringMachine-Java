package com.hideioushumpbackfreak.turningmachine;

import java.util.List;
import java.util.Optional;

public class Machine {

    private final int state;
    private final Head head;
    private final List<Transition> transitionTable;

    public Machine(int state, Head head, List<Transition> transitionTable) {

        this.state = state;
        this.head = head;
        this.transitionTable = transitionTable;
    }

    public int getState() {
        return state;
    }

    public Head getHead() {
        return head;
    }

    public Machine step() {
        if (this.getState() < 0) return this;

        Transition next = getNextTransition();

        return new Machine(
                next.getNextState(),
                this.getHead()
                        .write(next.getWrite())
                        .move(next.getHeadDirection()),
                this.transitionTable);
    }

    public Machine run() {
        Machine m = this;

        while (m.getState() >= 0)
            m = m.step();

        return m;
    }

    private Transition getNextTransition() {
        Optional<Transition> maybe = this.transitionTable
                .stream()
                .filter(t -> t.getInitialState() == this.getState() && t.getRead() == this.getHead().read())
                .findFirst();

        return maybe.isPresent() ?
                maybe.get() :
                this.errorTransition();
    }

    private Transition errorTransition() {
        return new Transition(0, Head.BLANK_SYMBOL, this.getHead().read(), HeadDirection.NoMove, State.ERROR);
    }
}