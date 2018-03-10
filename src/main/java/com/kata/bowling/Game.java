package com.kata.bowling;

/**
 * http://kata-log.rocks/bowling-game-kata
 * <p>
 * Bowling Rules
 * The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins.
 * The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.
 * <p>
 * A spare is when the player knocks down all 10 pins in two rolls.
 * The bonus for that frame is the number of pins knocked down by the next roll.
 * <p>
 * A strike is when the player knocks down all 10 pins on his first roll.
 * The frame is then completed with a single roll.
 * The bonus for that frame is the value of the next two rolls.
 * <p>
 * In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame.
 * However no more than three balls can be rolled in tenth frame.
 * <p>
 * Requirements
 * Write a class Game that has two methods
 * <p>
 * void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
 * int score() returns the total score for that game.
 */

class Game {

    private int currentScore = 0;

    private int numberOfThrowsPerFrame = 0;
    private int numberOfFrames = 0;
    private int lastRoll = 0;
    private boolean endOfFrame;
    private boolean spareInLastFrame;
    private boolean strikeInLastFrame;

    public void roll(int latestThrow) {

        System.out.println("-----------------------");
        System.out.println("Score before throw " + currentScore);
        System.out.println("No of pins rolled over in this roll " + latestThrow);

        numberOfThrowsPerFrame++;

        if (isEndOfFrame(latestThrow, numberOfThrowsPerFrame)) {

            endOfFrameWork(latestThrow);
        } else {
            //cache last throw
            lastRoll = latestThrow;
        }

        System.out.println("-----score updated ----");
        System.out.println("Last throw " + lastRoll);
        System.out.println("Current Score " + currentScore);
        System.out.println("No. of throws " + numberOfThrowsPerFrame);
        System.out.println("No. of frames " + numberOfFrames);
        System.out.println("-----------------------");

    }

    private void endOfFrameWork(int latestThrow) {

        numberOfFrames++;

        //Strike part
        if (isStrike(latestThrow)) {
            strikeWork();
        } else

            //Spare part
            if (isSpare(latestThrow)) {
                spareWork();
            } else {

                evaluateScore(latestThrow);

                //reset
                resetForNextFrame();
            }
    }

    private void evaluateScore(int latestThrow) {
        if (spareInLastFrame) {
            //last frame scored a spare
            //this time hit two throws without a spare (less then 10)
            currentScore = currentScore + (2 * lastRoll) + latestThrow;

        } else if (strikeInLastFrame) {
            //last frame scored a strike
            //this time hit two throws without a spare
            currentScore = currentScore + (latestThrow + lastRoll) * 2;
        } else {
            currentScore = currentScore + latestThrow + lastRoll;
        }
    }

    private boolean isSpare(int latestThrow) {
        return lastRoll + latestThrow == 10;
    }

    private boolean isStrike(int latestThrow) {
        return latestThrow == 10;
    }

    private void spareWork() {
        spareInLastFrame = true;
        currentScore = currentScore + 10;

        //reset
        resetForNextFrame();
    }

    private void strikeWork() {
        strikeInLastFrame = true;
        currentScore = currentScore + 10;

        //reset
        resetForNextFrame();
    }

    private boolean isEndOfFrame(int latestThrow, int numberOfThrowsPerFrame) {
        return ((numberOfThrowsPerFrame % 2) == 0 || isStrike(latestThrow));
    }

    private void resetForNextFrame() {
        endOfFrame = false;
        lastRoll = 0;
        numberOfThrowsPerFrame = 0;
    }


    public int score() {
        return currentScore;
    }
}
