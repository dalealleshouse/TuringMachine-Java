package com.hideioushumpbackfreak.turningmachine;

public class Head {
    public static final char BLANK_SYMBOL = '_';
    private final char[] tape;
    private final int headPosition;

    public Head(char[] tape, int headPosition) {
        if (headPosition < 0 || headPosition >= tape.length)
            throw new IndexOutOfBoundsException("headPosition");

        this.tape = tape;
        this.headPosition = headPosition;
    }

    public char[] getTape() {
        return this.tape;
    }

    public int getHeadPosition() {
        return this.headPosition;
    }
}