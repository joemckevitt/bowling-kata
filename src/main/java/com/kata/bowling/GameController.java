package com.kata.bowling;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  private final BowlingMatch bowlingMatch;

  public GameController() {
    bowlingMatch = new BowlingMatch();
  }

  @RequestMapping("/score")
  public GameResponse score() {
    bowlingMatch.roll(3);
    return new GameResponse(bowlingMatch.score(), bowlingMatch.getScoreSheet());
  }

}
