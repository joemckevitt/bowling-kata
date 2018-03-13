package com.kata.bowling;

class BowlingMatch {

    private Game game = new Game();

    private int currentScore = 0;
    private int numberOfThrowsPerFrame = 0;
    private int numberOfFrames = 0;
    private int lastRoll = 0;

    public void roll(int latestThrow) {

        System.out.println("-----------------------");
        System.out.println("Score before throw " + currentScore);
        System.out.println("No of pins rolled over in this roll " + latestThrow);

        numberOfThrowsPerFrame++;
        //take a throw (internally increment throw per frame count
        boolean endOfFrame = game.roll(latestThrow);

        if (endOfFrame) {
            currentScore = game.getScore();
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

    public int score() {
        return currentScore;
    }
}
