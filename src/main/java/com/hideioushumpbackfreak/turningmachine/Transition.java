package com.hideioushumpbackfreak.turningmachine;

public class Transition {
    private final int initialState;
    private final char read;
    private final char write;
    private final HeadDirection headDirection;
    private final int nextState;

    public Transition(int initialState, char read, char write, HeadDirection headDirection, int nextState) {
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
}