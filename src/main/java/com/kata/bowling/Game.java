package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int NO_OF_FRAMES = 10;
    private List<Frame> frames;
    private int currentFrameCursor = 0;

    Game() {

        frames = new ArrayList<Frame>(NO_OF_FRAMES);
        for (int i = 1; i <= NO_OF_FRAMES; i++) {
            frames.add(new Frame(i));
        }

    }

    /**
     * adds the latest score to the current frame and updates running total
     *
     * @param noOfPinsKnockedDown score of latest throw
     */
    public void roll(int noOfPinsKnockedDown) {

        boolean frameOver = false;

        for (int i = currentFrameCursor; i > currentFrameCursor - 3; i--) {
            if (i >= 0) {
                Frame frame = frames.get(i);
                //frame.addBonusScore(noOfPinsKnockedDown);
                frame.roll(noOfPinsKnockedDown);
            }

        }

        frameOver = frames.get(currentFrameCursor).isMoveOnNextFrame();

        if (frameOver) {
            //update the pointer to the next frame
            currentFrameCursor++;
        }


//        //check previous frame if its still active (open to listening to scores)
//        if (currentFrameCursor != 0 && !frames.get(currentFrameCursor - 1).isClosed()) {
//            Frame prevousFrame = frames.get(currentFrameCursor - 1);
//            prevousFrame.addBonusScore(noOfPinsKnockedDown);
//        }
//
//        if (currentFrameCursor >= 2 && !frames.get(currentFrameCursor - 2).isClosed()) {
//            Frame prevousFrame = frames.get(currentFrameCursor - 2);
//            prevousFrame.addBonusScore(noOfPinsKnockedDown);
//        }
//
//        //grab the current frame
//        Frame frame = frames.get(currentFrameCursor);
//
//        //add the score to the frame
//        boolean frameOver = frame.roll(noOfPinsKnockedDown);
//
//        //detect if the frame is over (could be on the first throw if its a strike)
//        if (frameOver) {
//            //calculateFrameScore(frame);
//            //update the pointer to the next frame
//            currentFrameCursor++;
//        }
    }

    public int getScore() {
        int gameScore = 0;
        for (int i = 0; i < NO_OF_FRAMES; i++) {
            Frame frame = frames.get(i);
            gameScore = gameScore + frame.getScore();
        }
        return gameScore;
    }
}
