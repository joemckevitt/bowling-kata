package com.kata.bowling;

public class ScoresheetPrinter {

  /**
   * Return print friendly version of score sheet.
   */
  public static Scoresheet generateScoreSheet(Game game) {
    Scoresheet scoresheet = new Scoresheet();
    for (Frame frame : game.getFrames()) {

      if (frame.isFirstThrowTaken()) {
        if (frame.getFrameSequence() == 1) {
          scoresheet.setLine1("|-----|");
          scoresheet.setLine2("|--" + frame.getFrameSequence() + "--|");
          scoresheet.setLine3("|" + frame.returnLine3());
          scoresheet.setLine4("|" + frame.returnLine4());
          scoresheet.setLine5("|-----|");
        } else if (frame.getFrameSequence() == 10) {
          //if last frame
          scoresheet.setLine1("------|");
          scoresheet.setLine2("--" + frame.getFrameSequence() + "--|");
          scoresheet.setLine3(frame.returnLine3());
          scoresheet.setLine4(frame.returnLine4());
          scoresheet.setLine5("------|");

        } else {
          scoresheet.setLine1("-----|");
          scoresheet.setLine2("--" + frame.getFrameSequence() + "--|");
          scoresheet.setLine3(frame.returnLine3());
          scoresheet.setLine4(frame.returnLine4());
          scoresheet.setLine5("-----|");
        }
      }
    }

    return scoresheet;
  }
}
