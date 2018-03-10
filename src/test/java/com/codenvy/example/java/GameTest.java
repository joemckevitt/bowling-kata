package com.codenvy.example.java;

import static org.junit.Assert.*;

import org.eclipse.che.examples.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class GameTest {

    @Test
    public void testSingleThrowOf5() {
        Game game = new Game();
        game.roll(5);
        assertEquals(0, game.score());
    }
  
    @Test
    public void testTwoThrowsFirstFrame() {
        Game game = new Game();
        game.roll(7);
        game.roll(1);
        assertEquals(8, game.score());
    }
    
    @Test
    public void testTwoThrowsUnderTen() {
        Game game = new Game();
        game.roll(5);
        game.roll(4);
        assertEquals(9, game.score());
    }
    
    
    @Test
    public void testSpareAndNextFrameUnderTen() {
        Game game = new Game();
        game.roll(5);
        game.roll(5);//spare
        game.roll(4);//10 + first throw making first frame 14
        game.roll(3);//2nd frame total 7
        assertEquals(21, game.score());
    }
    
        @Test
    public void testSpareExample() {
        Game game = new Game();
        game.roll(8);
        game.roll(2);//spare
        game.roll(5);//10 + first throw making first frame 5
        game.roll(4);//2nd frame total 9
        assertEquals(24, game.score());
    }
}
