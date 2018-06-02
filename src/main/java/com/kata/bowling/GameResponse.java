package com.kata.bowling;

public class GameResponse {

  private final int score;
  private final Scoresheet scoresheet;

  GameResponse(int score, Scoresheet scoresheet) {
    this.score = score;
    this.scoresheet = scoresheet;
  }

  public int getScore() {
    return score;
  }

  public Scoresheet getScoresheet() {
    return scoresheet;
  }
}
