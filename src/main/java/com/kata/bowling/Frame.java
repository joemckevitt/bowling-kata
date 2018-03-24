package com.kata.bowling;

public class Frame {

    private static final int ALL_PINS = 10;

    private int frameSequence;

    private int firstThrow;
    private int secondThrow;
    private boolean firstThrowTaken;

    private boolean strikeScored;
    private boolean spareScored;

    private int bonusThrow1;
    private int bonusThrow2;

    private boolean moveOnNextFrame;

    private boolean closed = false;

    Frame(int frameSequence) {
        this.frameSequence = frameSequence;
    }

    /**
     * roll
     *
     * @param noOfPinsKnockedDown Number of pins knocked down
     */
    public void roll(int noOfPinsKnockedDown) {

        if (noOfPinsKnockedDown < 0 || noOfPinsKnockedDown > ALL_PINS) {
            throw new IllegalArgumentException("invalid number of pins");
        }

        if (closed) {
            //TODO horrible, tidy up
            //do nothing
        } else if (spareScored || strikeScored) {
            closed = addBonusScore(noOfPinsKnockedDown);
        } else if (firstThrowOfFrame()) {
            moveOnNextFrame = doFirstThrowWork(noOfPinsKnockedDown);
        } else {
            moveOnNextFrame = doSecondThrowWork(noOfPinsKnockedDown);
        }
    }

    private boolean addBonusScore(int bonusThrow) {

        if (spareScored) {
            bonusThrow1 = bonusThrow;
            closed = true;
        } else if (strikeScored) {
            if (bonusThrow1 != 0) {
                //TODO fix potential bug as the bonus thow for a strike may be 0 (a miss)
                bonusThrow2 = bonusThrow;
                closed = true;
            } else {
                //first bonus throw on strike
                bonusThrow1 = bonusThrow;
            }
        }
        return closed;
    }

    private boolean doFirstThrowWork(int currentThrow) {

        setFirstThrow(currentThrow);
        firstThrowTaken = true;

        //detect if its a strike
        if (isStrike()) {
            strikeScored = true;
            return true;
        } else {
            return false;
        }
    }

    private boolean doSecondThrowWork(int currentThrow) {

        setSecondThrow(currentThrow);

        int totalScore = firstThrow + secondThrow;

        if (totalScore > ALL_PINS) {
            throw new IllegalArgumentException("invalid number of pins");
        }

        if (spareScored()) {
            spareScored = true;
        } else {
            closed = true;
        }
        return true;
    }

    private boolean isStrike() {
        return firstThrow == ALL_PINS;
    }

    private boolean spareScored() {
        return (firstThrow != 10) && (firstThrow + secondThrow == ALL_PINS);
    }

    private boolean firstThrowOfFrame() {
        return !firstThrowTaken;
    }

    private void setFirstThrow(int firstThrow) {
        System.out.println("First throw taken of " + firstThrow + " from frame " + frameSequence);
        this.firstThrow = firstThrow;
    }

    private void setSecondThrow(int secondThrow) {
        System.out.println("Second throw taken of " + secondThrow + " from frame " + frameSequence +
                "  - first throw of " + firstThrow);
        this.secondThrow = secondThrow;
    }

    public int getScore() {

        if (!closed)
            return 0;

        if (strikeScored) {
            return firstThrow + bonusThrow1 + bonusThrow2;
        } else if (spareScored) {
            return firstThrow + secondThrow + bonusThrow1;
        } else {
            return firstThrow + secondThrow;
        }

    }

    public boolean isMoveOnNextFrame() {
        return moveOnNextFrame;
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
                ", bonusThrow1=" + bonusThrow1 +
                ", bonusThrow2=" + bonusThrow2 +
                ", moveOnNextFrame=" + moveOnNextFrame +
                ", closed=" + closed +
                '}';
    }
}
