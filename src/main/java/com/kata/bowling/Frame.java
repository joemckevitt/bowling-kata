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


    private boolean closed = false;

    Frame(int frameSequence) {
        this.frameSequence = frameSequence;
    }

    /**
     * roll
     *
     * @param noOfPinsKnockedDown Number of pins knocked down
     * @return turn if current frame has ended (note if a strike or spare, it will
     * return true but may still be active)
     */
    public boolean roll(int noOfPinsKnockedDown) {

        if (noOfPinsKnockedDown < 0 || noOfPinsKnockedDown > ALL_PINS) {
            throw new IllegalArgumentException("invalid number of pins");
        }

        if (firstThrowOfFrame()) {
            return doFirstThrowWork(noOfPinsKnockedDown);
        } else {
            return doSecondThrowWork(noOfPinsKnockedDown);
        }

    }

    public boolean addBonusScore(int bonusThrow) {

        if (closed)
            throw new IllegalArgumentException("can not add a bonus score to a closed frame");

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

    private boolean doSecondThrowWork(int currentThrow) {

        setSecondThrow(currentThrow);

        if (getScore() > ALL_PINS) {
            throw new IllegalArgumentException("invalid number of pins");
        }

        if (spareScored(getScore())) {
            spareScored = true;
        } else {
            closed = true;
        }
        return true;
    }

    private boolean spareScored(int score) {
        return (firstThrow != 10) && (firstThrow + secondThrow == ALL_PINS);
    }

    private boolean doFirstThrowWork(int currentThrow) {

        setFirstThrow(currentThrow);
        setFirstThrowTaken(true);

        //detect if its a strike
        if (isStrike()) {
            strikeScored = true;
            return true;
        } else {
            return false;
        }
    }

    private boolean isStrike() {
        return firstThrow == ALL_PINS;
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
        if (closed && (strikeScored)) {
            return firstThrow + bonusThrow1 + bonusThrow2;
        } else if (closed && spareScored) {
            return firstThrow + secondThrow + bonusThrow1;
        } else {
            return firstThrow + secondThrow;
        }

    }

    private void setFirstThrowTaken(boolean firstThrowTaken) {
        this.firstThrowTaken = firstThrowTaken;
    }

    public boolean isClosed() {
        return closed;
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
                ", closed=" + closed +
                '}';
    }
}
