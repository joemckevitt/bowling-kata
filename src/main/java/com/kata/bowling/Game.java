package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames;
    private int score;
    private int currentFrameCursor;
    private boolean endOfFrame;

    Game() {

        frames = new ArrayList<Frame>(10);
        for (int i = 1; i < 11; i++) {
            frames.add(new Frame(i));
        }

        score = 0;
        currentFrameCursor = 0;//first frame of new game
        endOfFrame = false;
        //i think at some point, i'll probably need a endOfGame flag
    }


    /**
     * adds the latest score to the current frame and updates running total
     *
     * @param noOfPinsKnockedDown score of latest throw
     * @return returns true if its the end of frame
     */
    public boolean roll(int noOfPinsKnockedDown) {

        //grab the current frame
        Frame frame = frames.get(currentFrameCursor);

        //add the score to the frame
        boolean frameOver = frame.roll(noOfPinsKnockedDown);

        //detect if the frame is over (could be on the first throw if its a strike)
        if (frameOver) {

            if (frame.isStrikeScored() || frame.isSpareScored()) {
                score = score + frame.getScore();
            } else {
                //TODO next to refactor and clean up
                //check if previous frame was a spare
                if (currentFrameCursor > 0) {
                    Frame previousFrame = frames.get(currentFrameCursor - 1);
                    if (previousFrame.isSpareScored()) {
                        //last frame scored a spare
                        //this time hit two throws without a spare (less then 10)
                        score = score + (2 * frame.getFirstThrow()) + frame.getSecondThrow();
                    } else if (previousFrame.isStrikeScored()) {
                        //last frame scored a strike
                        //this time hit two throws without a spare
                        score = score + frame.getScore() * 2;
                    } else {
                        score = score + frame.getScore();
                    }
                } else {
                    score = score + frame.getScore();
                }
            }

            //update the pointer to the next frame and return true
            currentFrameCursor++;
            return true;
        } else {
            //score = score + frame.getScore();
            return false;
        }
    }

    public int getScore() {
        return score;
    }
}
