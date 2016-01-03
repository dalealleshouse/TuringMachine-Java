package com.hideioushumpbackfreak.turningmachine;

import com.google.common.collect.ImmutableSet;

import static java.util.Objects.requireNonNull;

public final class Machine {
    private final int state;
    private final Head head;
    private final ImmutableSet<Transition> transitionTable;

    public Machine(int state, Head head, ImmutableSet<Transition> transitionTable) {
        requireNonNull(head);
        requireNonNull(transitionTable);

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
        return this.transitionTable
                .stream()
                .filter(this::isNextTransition)
                .findFirst()
                .orElse(this.errorTransition());
    }

    private boolean isNextTransition(Transition t) {
        return t.getInitialState() == this.getState() && t.getRead() == this.getHead().read();
    }

    private Transition errorTransition() {
        return new Transition(0, Head.BLANK_SYMBOL, this.getHead().read(), HeadDirection.NoMove, State.ERROR);
    }
}