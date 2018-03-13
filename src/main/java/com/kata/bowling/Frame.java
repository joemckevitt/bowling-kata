package com.kata.bowling;

public class Frame {

    int frameSequence;
    int firstThrow;
    int secondThrow;
    int score;
    public boolean firstThrowTaken;
    public boolean frameOver;

    public Frame(int frameSequence) {
        this.frameSequence = frameSequence;
        firstThrowTaken = false;
        frameOver = false;
    }

    public int getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(int firstThrow) {
        this.firstThrow = firstThrow;
    }

    public int getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(int secondThrow) {
        this.secondThrow = secondThrow;
        firstThrowTaken = true;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //TODO update with new fields
    @Override
    public String toString() {
        return "Frame{" +
                "frameSequence=" + frameSequence +
                ", firstThrow=" + firstThrow +
                ", secondThrow=" + secondThrow +
                ", score=" + score +
                '}';
    }
}
