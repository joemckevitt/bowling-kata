package com.kata.bowling;

public class Frame {

    public static final int ALL_PINS = 10;

    private int frameSequence;

    private int firstThrow;
    private int secondThrow;
    private boolean firstThrowTaken;

    private boolean strikeScored;
    private boolean spareScored;

    Frame(int frameSequence) {
        this.frameSequence = frameSequence;
        firstThrowTaken = false;
    }

    public boolean roll(int currentThrow) {

        if (firstThrowOfFrame()) {
            return doFirstThrowWork(currentThrow);
        } else {
            return doSecondThrowWork(currentThrow);
        }

    }

    private boolean doSecondThrowWork(int currentThrow) {
        setSecondThrow(currentThrow);
        if (spareScored(getScore())) {
            spareScored = true;
        }
        return true;
    }

    private boolean spareScored(int score) {
        return score == ALL_PINS;
    }

    private boolean doFirstThrowWork(int currentThrow) {
        setFirstThrow(currentThrow);
        setFirstThrowTaken(true);

        //detect if its a strike
        if (isStrike(currentThrow)) {
            strikeScored = true;
            return true;
        } else {
            return false;
        }
    }

    private boolean isStrike(int currentThrow) {
        return spareScored(currentThrow);
    }

    private boolean firstThrowOfFrame() {
        return !firstThrowTaken;
    }

    public int getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(int firstThrow) {
        System.out.println("First throw taken of " + firstThrow + " from frame " + frameSequence);
        this.firstThrow = firstThrow;
    }

    public int getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(int secondThrow) {
        System.out.println("Second throw taken of " + secondThrow + " from frame " + frameSequence);
        this.secondThrow = secondThrow;
    }

    public int getScore() {
        return firstThrow + secondThrow;
    }

    public boolean isStrikeScored() {
        return strikeScored;
    }

    public boolean isSpareScored() {
        return spareScored;
    }

    private void setFirstThrowTaken(boolean firstThrowTaken) {
        this.firstThrowTaken = firstThrowTaken;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "frameSequence=" + frameSequence +
                ", firstThrow=" + firstThrow +
                ", secondThrow=" + secondThrow +
                ", firstThrowTaken=" + firstThrowTaken +
                ", strikeScored=" + strikeScored +
                ", spareScored=" + spareScored +
                '}';
    }
}
