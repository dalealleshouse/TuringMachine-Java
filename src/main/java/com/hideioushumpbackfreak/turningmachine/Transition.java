package com.hideioushumpbackfreak.turningmachine;

import static java.util.Objects.requireNonNull;

public final class Transition {
    private final int initialState;
    private final char read;
    private final char write;
    private final HeadDirection headDirection;
    private final int nextState;

    public Transition(int initialState, char read, char write, HeadDirection headDirection, int nextState) {
        requireNonNull(headDirection);

        this.initialState = initialState;
        this.read = read;
        this.write = write;
        this.headDirection = headDirection;
        this.nextState = nextState;
    }

    public int getInitialState() {
        return initialState;
    }

    public char getRead() {
        return read;
    }

    public char getWrite() {
        return write;
    }

    public HeadDirection getHeadDirection() {
        return headDirection;
    }

    public int getNextState() {
        return nextState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transition that = (Transition) o;

        return initialState == that.initialState &&
                read == that.read &&
                write == that.write &&
                nextState == that.nextState &&
                headDirection == that.headDirection;
    }

    @Override
    public int hashCode() {
        int result = initialState;
        result = 31 * result + (int) read;
        result = 31 * result + (int) write;
        result = 31 * result + headDirection.hashCode();
        result = 31 * result + nextState;
        return result;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "initialState=" + initialState +
                ", read=" + read +
                ", write=" + write +
                ", headDirection=" + headDirection +
                ", nextState=" + nextState +
                '}';
    }
}