package com.kata.bowling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

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
    public void testTwoThrowsFirstFrame() {
        BowlingMatch bowlingMatch = new BowlingMatch();
        bowlingMatch.roll(7);
        bowlingMatch.roll(1);
        assertEquals(8, bowlingMatch.score());
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
}
