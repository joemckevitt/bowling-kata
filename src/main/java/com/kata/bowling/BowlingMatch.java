package com.kata.bowling;

class BowlingMatch {

    private Game game = new Game();

    private int currentScore = 0;
    private int numberOfFrames = 0;

    public void roll(int noOfPinsKnockedDown) {

        System.out.println("-----------------------");
        System.out.println("No of pins rolled over in this roll " + noOfPinsKnockedDown);

        game.roll(noOfPinsKnockedDown);

        System.out.println("-----------------------");

    }

    public int score() {
        return game.getScore();
    }
}
