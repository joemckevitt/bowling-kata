package com.kata.bowling;

class BowlingMatch {

    private Game game = new Game();

    private int currentScore = 0;
    private int numberOfThrowsPerFrame = 0;
    private int numberOfFrames = 0;
    private int lastRoll = 0;
    private boolean spareInLastFrame;
    private boolean strikeInLastFrame;

    public void roll(int latestThrow) {

        System.out.println("-----------------------");
        System.out.println("Score before throw " + currentScore);
        System.out.println("No of pins rolled over in this roll " + latestThrow);

        numberOfThrowsPerFrame++;
        //take a throw (internally increment throw per frame count
        boolean endOfFrame = game.roll(latestThrow);

        //if (endOfFrame) {
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
        lastRoll = 0;
        numberOfThrowsPerFrame = 0;
    }


    public int score() {
        return currentScore;
    }
}
