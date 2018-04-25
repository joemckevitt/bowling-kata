package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private static final int NO_OF_FRAMES = 10;

  private int scoreFromCompleteFrames;

  private List<Frame> frames;
  private int currentFrameCursor = 0;

  Game() {

    scoreFromCompleteFrames = 0;

    frames = new ArrayList<>(NO_OF_FRAMES);
    for (int i = 1; i <= NO_OF_FRAMES; i++) {
      frames.add(new Frame(i));
    }

  }

  public List<Frame> getFrames() {
    return frames;
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

    for (int i = currentFrameCursor - 2; i <= currentFrameCursor; i++) {
      if (i >= 0) {
        Frame frame = frames.get(i);
        if (!frame.isClosed()) {
          frame.roll(noOfPinsKnockedDown, scoreFromCompleteFrames);
          scoreFromCompleteFrames = scoreFromCompleteFrames + frame.getScore();
        }

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

    for (int i = NO_OF_FRAMES - 1; i >= 0; i--) {
      Frame frame = frames.get(i);
      if (frame.isClosed()) {
        return frame.getCumlativeScore();
      }
    }
    return 0;
  }
}
