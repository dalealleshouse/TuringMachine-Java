package com.hideioushumpbackfreak.turningmachine;

import java.util.stream.IntStream;

public final class Head {
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

    public char read() {
        return this.getTape()[this.getHeadPosition()];
    }

    public Head write(char symbol) {
        char[] data = this.getTape().clone();
        data[this.getHeadPosition()] = symbol;

        return new Head(data, this.getHeadPosition());
    }

    public Head moveLeft() {
        return this.getHeadPosition() == 0 ?
                new Head(ConcatArray(new char[]{Head.BLANK_SYMBOL}, this.getTape()), 0) :
                new Head(this.getTape(), this.getHeadPosition() - 1);
    }

    public Head moveRight() {
        return this.getHeadPosition() == this.getTape().length - 1 ?
                new Head(this.ConcatArray(this.getTape(), new char[]{BLANK_SYMBOL}), this.getHeadPosition() + 1) :
                new Head(this.getTape(), this.getHeadPosition() + 1);
    }

    public Head move(HeadDirection direction) {
        switch (direction) {
            case Left:
                return moveLeft();
            case NoMove:
                return this;
            case Right:
                return moveRight();
            default:
                throw new IndexOutOfBoundsException("direction");
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.getTape().length).mapToObj(this::getSymbol).reduce((acc, next) -> acc + next).get();
    }

    private String getSymbol(int index) {
        return (index == this.getHeadPosition()) ? String.format("(%1$s)", this.getTape()[index]) : "" + this.getTape()[index];
    }

    private char[] ConcatArray(char[] a, char[] b) {
        char[] together = new char[a.length + b.length];
        System.arraycopy(a, 0, together, 0, a.length);
        System.arraycopy(b, 0, together, a.length, b.length);

        return together;
    }
}