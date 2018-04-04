package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private static final int NO_OF_FRAMES = 10;
  private List<Frame> frames;
  private int currentFrameCursor = 0;

  Game() {

    frames = new ArrayList<>(NO_OF_FRAMES);
    for (int i = 1; i <= NO_OF_FRAMES; i++) {
      frames.add(new Frame(i));
    }

  }

  /**
   * adds the latest score to the current frame and updates running total.
   *
   * @param noOfPinsKnockedDown score of latest throw
   */
  public void roll(int noOfPinsKnockedDown) {

    if (currentFrameCursor == 9 && frames.get(currentFrameCursor).isClosed()) {
      throw new IllegalArgumentException();
    }

    for (int i = currentFrameCursor; i > currentFrameCursor - 3; i--) {
      if (i >= 0) {
        Frame frame = frames.get(i);
        frame.roll(noOfPinsKnockedDown);
      }

    }

    boolean frameOver = frames.get(currentFrameCursor).frameOver();

    if (frameOver) {
      //update the pointer to the next frame, accept if its the last frame
      if (currentFrameCursor < 9) {
        currentFrameCursor++;
      }
    }
  }

  /**
   * Return score of the game.
   *
   * @return Return score of the game.
   */
  public int getScore() {
    int gameScore = 0;
    for (int i = 0; i < NO_OF_FRAMES; i++) {
      Frame frame = frames.get(i);
      gameScore = gameScore + frame.getScore();
      frame.printScore();
    }
    return gameScore;
  }
}
