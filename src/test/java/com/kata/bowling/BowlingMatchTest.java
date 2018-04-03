package com.kata.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for bowling game
 */
@RunWith(JUnit4.class)
public class BowlingMatchTest {

  @Test
  public void testSingleThrowOf5() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(5);
    assertEquals(0, bowlingMatch.score());
  }

  @Test
  public void testTwoThrowsUnderTen() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(5);
    bowlingMatch.roll(4);
    assertEquals(9, bowlingMatch.score());
  }


  @Test
  public void testSpareAndNextFrameUnderTen() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(5);
    bowlingMatch.roll(5);//spare
    bowlingMatch.roll(4);//10 + first throw making first frame 14
    bowlingMatch.roll(3);//2nd frame total 7
    assertEquals(21, bowlingMatch.score());
  }

  @Test
  public void testSpareWithTwoFramesExample() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(8);
    bowlingMatch.roll(2);//spare
    bowlingMatch.roll(5);//10 + first throw making first frame 5
    bowlingMatch.roll(4);//2nd frame total 9
    assertEquals(24, bowlingMatch.score());
  }

  @Test
  public void testStrikeWithTwoFramesExample() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(10);//strike
    bowlingMatch.roll(5);
    bowlingMatch.roll(2);
    assertEquals(24, bowlingMatch.score());
  }

  @Test
  public void testTwoStrikesInARowExample1() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(10);//strike
    bowlingMatch.roll(10);//strike
    bowlingMatch.roll(1);
    bowlingMatch.roll(1);
    //frame 1 -> 21, frame 2 -> 33 (12), frame 3 -> 35 (2)
    assertEquals(35, bowlingMatch.score());
  }

  @Test
  public void testTwoStrikesInARowExample2() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(10);//strike
    bowlingMatch.roll(10);//strike
    bowlingMatch.roll(2);
    bowlingMatch.roll(3);
    //frame 1 -> 22, frame 2 -> 37 (15), frame 3 -> 42 (5)
    assertEquals(42, bowlingMatch.score());
  }

  @Test
  public void testFullBowlingMatch() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    assertEquals(30, bowlingMatch.score());
  }

  @Test
  public void testSpareLastFrame() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(5);
    bowlingMatch.roll(5);  //spare on the the last frame

    bowlingMatch.roll(8);

    assertEquals(45, bowlingMatch.score());
  }

  @Test
  public void testStrikeLastFrame() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(10); //strike on the the last frame

    bowlingMatch.roll(1);

    bowlingMatch.roll(2);

    assertEquals(40, bowlingMatch.score());
  }

  @Test
  public void testSpareLastFrameBonusThrowAStrike() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(5);
    bowlingMatch.roll(5); //spare last frame

    bowlingMatch.roll(10); //bonus throw a strike

    assertEquals(47, bowlingMatch.score());
  }

  @Test
  public void testStrikeLastFrameBonusThrowASpare() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(10); //strike last frame

    bowlingMatch.roll(5);
    bowlingMatch.roll(5); //bonus throws score a spare

    assertEquals(47, bowlingMatch.score());
  }

  @Test
  public void testStrikeLastFrameFirstBonusThrowAStrikeFollowdBy5() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(10); //strike last frame

    bowlingMatch.roll(10); //first bonus throw a strike
    bowlingMatch.roll(5);

    assertEquals(52, bowlingMatch.score());
  }

  @Test
  public void test3StrikesLastFrame() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(10); //strike last frame

    bowlingMatch.roll(10); //first bonus throw a strike
    bowlingMatch.roll(10); //first bonus throw a strike

    assertEquals(57, bowlingMatch.score());
  }

  @Test
  public void testStrikesLastFrameFollowedByGutterBallAndScore() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(10); //strike last frame

    bowlingMatch.roll(0); //first bonus throw a strike
    bowlingMatch.roll(5); //first bonus throw a strike

    assertEquals(42, bowlingMatch.score());
  }

  public void testMaxScore() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(10);
    bowlingMatch.roll(10);
    bowlingMatch.roll(10);
    bowlingMatch.roll(10);
    bowlingMatch.roll(10);

    bowlingMatch.roll(10);
    bowlingMatch.roll(10);
    bowlingMatch.roll(10);
    bowlingMatch.roll(10);

    bowlingMatch.roll(10); //strike last frame

    bowlingMatch.roll(10); //first bonus throw a strike
    bowlingMatch.roll(10); //first bonus throw a strike

    assertEquals(300, bowlingMatch.score());
  }

  @Test
  public void testGutter() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(0);
    assertEquals(0, bowlingMatch.score());
  }

  @Test
  public void testGutter2BallsInARow() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    assertEquals(0, bowlingMatch.score());
  }

  @Test
  public void testGutter3BallsInARow() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    assertEquals(0, bowlingMatch.score());
  }

  @Test
  public void testGutter4BallsInARow() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    assertEquals(0, bowlingMatch.score());
  }

  @Test
  public void testGutter5BallsInARow() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    assertEquals(0, bowlingMatch.score());
  }

  @Test
  public void testGutter6BallsInARow() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    bowlingMatch.roll(0);
    assertEquals(0, bowlingMatch.score());
  }

  //Boundary tests

  @Test(expected = IllegalArgumentException.class)
  public void testExtraThrowAfterMatchIsOver() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);
    bowlingMatch.roll(2);

    bowlingMatch.roll(1);//extra throw
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSingleThrowOfNegativeScore() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSingleThrowMoreThanTen() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFrameScoreGreaterThanTen() {
    BowlingMatch bowlingMatch = new BowlingMatch();
    bowlingMatch.roll(8);
    bowlingMatch.roll(3);//spare
  }
}
