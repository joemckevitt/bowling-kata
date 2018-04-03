package com.kata.bowling;

class BowlingMatch {

  private Game game = new Game();

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
