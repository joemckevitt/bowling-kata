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
        currentFrameCursor = 1;//first frame of new game
        endOfFrame = false;
        //i think at some point, i'll probably need a endOfGame flag
    }


    /**
     * adds the latest score to the current frame and updates running total
     *
     * @param scoreOfCurrentThrow score of latest throw
     * @return returns true if its the end of frame
     */
    public boolean roll(int scoreOfCurrentThrow) {
        
        //grab the current frame
        Frame frame = frames.get(currentFrameCursor);
        
        //add the score to the frame
        //TODO encapsulate this check inside frame
        if (!frame.isFirstThrowTaken()) {
            frame.setFirstThrow(scoreOfCurrentThrow);
            frame.setFirstThrowTaken(true);

            //detect if its a strike
            if (scoreOfCurrentThrow == 10) {
                frame.setFrameOver(true);
            }

        } else  {
            frame.setSecondThrow(scoreOfCurrentThrow);
            frame.setFrameOver(true);
        }
        
        //detect if the frame is over (could be on the first throw if its a strike)
        if (frame.isFrameOver()) {

            if (frame.getScore() == 10 && frame.getSecondThrow() == 0) {
                frame.setStrikeScored(true);
                score = score + frame.getScore();
            } else if (frame.getScore() == 10) {
                frame.setSpareScored(true);
                score = score + frame.getScore();
            } else {
                //check if previous frame was a spare
                if (currentFrameCursor > 1) {
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
        } else  {
            //score = score + frame.getScore();
            return false;
        }
    }

    public int getScore() {
        return score;
    }
}
