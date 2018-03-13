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
     * @param score score of latest throw
     * @return returns true if its the end of frame
     */
    public boolean roll(int score) {
        
        //grab the current frame
        Frame frame = frames.get(currentFrameCursor);
        
        //add the score to the frame
        //TODO encapsulate this check inside frame
        if (frame.firstThrowTaken)   {
            frame.setFirstThrow(score);
        } else  {
            frame.setSecondThrow(score);
        }
        
        //detect if the frame is over (could be on the first throw if its a strike)
        if (frame.frameOver)   {
            //if so, update the pointer to the next frame and return true
            currentFrameCursor++;
            score = score + frame.getScore();
            return true;
        } else  {
            score = score + frame.getScore();
            return false;
        }
    }
}
