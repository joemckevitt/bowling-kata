package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames;
    private int score;
    private int currentFrame;
    private boolean endOfFrame;

    Game() {
        frames = new ArrayList<Frame>(10);
        score = 0;
        currentFrame = 0;
        endOfFrame = false;
    }


    /**
     * adds the latest score to the current frame and updates running total
     *
     * @param score score of latest throw
     * @return returns true if its the end of frame
     */
    public boolean roll(int score) {
        return false;
    }
}
