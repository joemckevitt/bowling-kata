package com.kata.bowling;

public class Frame {

    private int frameSequence;
    private int firstThrow;
    int secondThrow;
    public boolean firstThrowTaken;
    public boolean frameOver;
    private boolean strikeScored;
    private boolean spareScored;

    Frame(int frameSequence) {
        this.frameSequence = frameSequence;
        firstThrowTaken = false;
        frameOver = false;
    }

    public int getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(int firstThrow) {
        this.firstThrow = firstThrow;
    }

    public int getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(int secondThrow) {
        this.secondThrow = secondThrow;
    }

    public int getScore() {
        return firstThrow + secondThrow;
    }

    public boolean isStrikeScored() {
        return strikeScored;
    }

    public void setStrikeScored(boolean strikeScored) {
        this.strikeScored = strikeScored;
    }

    public boolean isSpareScored() {
        return spareScored;
    }

    public void setSpareScored(boolean spareScored) {
        this.spareScored = spareScored;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "frameSequence=" + frameSequence +
                ", firstThrow=" + firstThrow +
                ", secondThrow=" + secondThrow +
                ", firstThrowTaken=" + firstThrowTaken +
                ", frameOver=" + frameOver +
                ", strikeScored=" + strikeScored +
                ", spareScored=" + spareScored +
                '}';
    }
}
