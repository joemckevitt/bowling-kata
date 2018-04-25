package com.kata.bowling;

public class Frame {

  private static final int ALL_PINS = 10;

  private int cumlativeScore;

  private int frameSequence;

  private int firstThrow;
  private int secondThrow;

  public int getFrameSequence() {
    return frameSequence;
  }

  private boolean firstThrowTaken;

  private boolean strikeScored;
  private boolean spareScored;

  private int bonusThrow1;
  private boolean firstBonusThrowTaken;
  private int bonusThrow2;

  private boolean frameOver;

  private boolean closed = false;

  public boolean isFirstThrowTaken() {
    return firstThrowTaken;
  }

  Frame(int frameSequence) {
    this.frameSequence = frameSequence;
  }

  /**
   * The number of pins knocked down for a given throw.
   *
   * @param noOfPinsKnockedDown Number of pins knocked down
   * @param scoreFromCompleteFrames Score from completed frames
   */
  public void roll(int noOfPinsKnockedDown, int scoreFromCompleteFrames) {

    if (noOfPinsKnockedDown < 0 || noOfPinsKnockedDown > ALL_PINS) {
      throw new IllegalArgumentException("invalid number of pins");
    }

    if (!closed) {
      if (spareScored || strikeScored) {
        closed = addBonusScore(noOfPinsKnockedDown);
      } else if (firstThrowOfFrame()) {
        frameOver = doFirstThrowWork(noOfPinsKnockedDown);
      } else {
        frameOver = doSecondThrowWork(noOfPinsKnockedDown);
      }

      //update cumlative score if frame is now closed
      if (isClosed()) {
        cumlativeScore = scoreFromCompleteFrames + getScore();
      }

    }
  }

  private boolean addBonusScore(int bonusThrow) {

    if (spareScored) {
      bonusThrow1 = bonusThrow;
      firstBonusThrowTaken = true;
      closed = true;
    } else if (strikeScored) {
      if (firstBonusThrowTaken) {
        bonusThrow2 = bonusThrow;
        closed = true;
      } else {
        //first bonus throw on strike
        bonusThrow1 = bonusThrow;
        firstBonusThrowTaken = true;
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
    return (firstThrow != ALL_PINS) && (firstThrow + secondThrow == ALL_PINS);
  }

  private boolean firstThrowOfFrame() {
    return !firstThrowTaken;
  }

  private void setFirstThrow(int firstThrow) {
    //TODO ditch the system outs and replace with loggers
    System.out.println("First throw taken of " + firstThrow + " from frame " + frameSequence);
    this.firstThrow = firstThrow;
  }

  private void setSecondThrow(int secondThrow) {
    System.out.println("Second throw taken of " + secondThrow + " from frame " + frameSequence
        + "  - first throw of " + firstThrow);
    this.secondThrow = secondThrow;
  }

  /**
   * Return score of the frame.
   *
   * @return Return score of the frame.
   */
  public int getScore() {

    if (!closed) {
      return 0;
    }

    if (strikeScored) {
      return firstThrow + bonusThrow1 + bonusThrow2;
    } else if (spareScored) {
      return firstThrow + secondThrow + bonusThrow1;
    } else {
      return firstThrow + secondThrow;
    }

  }

  public boolean frameOver() {
    return frameOver;
  }

  public boolean isClosed() {
    return closed;
  }

  /**
   * Return line suitable for score card line 3.
   * @return Return line suitable for score card line 3
   */
  public String returnLine3() {

    if (frameSequence == 10) {
      if (strikeScored) {
        if (bonusThrow1 == 10 && bonusThrow2 == 10) {
          return " X|X|X|";
        } else if (bonusThrow1 == 10) {
          return " X|X|" + bonusThrow2 + "|";
        } else {
          return " X|" + bonusThrow1 + "|" + bonusThrow2 + "|";
        }
      } else if (spareScored) {
        return " " + firstThrow + "|/|" + bonusThrow1 + "|";
      } else {
        return " " + firstThrow + "|" + secondThrow + "|0|";
      }
    } else {
      if (strikeScored) {
        return "   |X|";
      } else if (spareScored) {
        return "  " + firstThrow + "|/|";
      } else {
        return "  " + firstThrow + "|" + secondThrow + "|";
      }
    }


  }

  /**
   * Return line suitable for score card line 4.
   *
   * @return Return line suitable for score card line 4
   */
  public String returnLine4() {

    if (!isClosed()) {
      if (frameSequence == 10) {
        return "      |";
      } else {
        return "     |";
      }
    }

    if (frameSequence == 10) {
      if (getCumlativeScore() < 10) {
        return "   " + getCumlativeScore() + "  |";
      } else {
        return "   " + getCumlativeScore() + " |";
      }
    } else {
      if (getCumlativeScore() < 10) {
        return "  " + getCumlativeScore() + "  |";
      } else {
        return "  " + getCumlativeScore() + " |";
      }
    }
  }

  public int getCumlativeScore() {
    return cumlativeScore;
  }

  @Override
  public String toString() {
    return "Frame{"
        + "frameSequence="
        + frameSequence
        + ", firstThrow="
        + firstThrow
        + ", secondThrow="
        + secondThrow
        + ", firstThrowTaken="
        + firstThrowTaken
        + ", strikeScored="
        + strikeScored
        + ", spareScored="
        + spareScored
        + ", bonusThrow1="
        + bonusThrow1
        + ", bonusThrow2="
        + bonusThrow2
        + ", frameOver="
        + frameOver
        + ", closed="
        + closed
        + '}';
  }
}
