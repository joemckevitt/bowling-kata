package com.kata.bowling;

public class Frame {

    private int frameSequence;
    private int firstThrow;
    private int secondThrow;
    private boolean firstThrowTaken;
    private boolean frameOver;
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

    public boolean isFirstThrowTaken() {
        return firstThrowTaken;
    }

    public void setFirstThrowTaken(boolean firstThrowTaken) {
        this.firstThrowTaken = firstThrowTaken;
    }

    public boolean isFrameOver() {
        return frameOver;
    }

    public void setFrameOver(boolean frameOver) {
        this.frameOver = frameOver;
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
