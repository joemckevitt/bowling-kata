package com.kata.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoresheetTest {

  @Test
  public void testSingleFrameSingleThrow() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(3);
    game.roll(3);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|", actualScoreSheet.getLine2());
    assertEquals("|  3|3|", actualScoreSheet.getLine3());
    assertEquals("|  6  |", actualScoreSheet.getLine4());
    assertEquals("|-----|", actualScoreSheet.getLine5());
//    "|--1--|"
//    "| 3|3|"
//    "| 6 |"
//    "|-----|"

  }

  @Test
  public void testSingleFrame() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(1);
    game.roll(2);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|", actualScoreSheet.getLine2());
    assertEquals("|  1|2|", actualScoreSheet.getLine3());
    assertEquals("|  3  |", actualScoreSheet.getLine4());
    assertEquals("|-----|", actualScoreSheet.getLine5());

  }

  @Test
  public void testTwoFrames() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(1);
    game.roll(2);
    game.roll(3);
    game.roll(4);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|", actualScoreSheet.getLine2());
    assertEquals("|  1|2|  3|4|", actualScoreSheet.getLine3());
    assertEquals("|  3  |  10 |", actualScoreSheet.getLine4());
    assertEquals("|-----|-----|", actualScoreSheet.getLine5());

  }

  @Test
  public void testStrikeWithTwoFrames() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(10);
    game.roll(1);
    game.roll(1);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|", actualScoreSheet.getLine2());
    assertEquals("|   |X|  1|1|", actualScoreSheet.getLine3());
    assertEquals("|  12 |  14 |", actualScoreSheet.getLine4());
    assertEquals("|-----|-----|", actualScoreSheet.getLine5());

  }

  @Test
  public void testSpareWithSingleFrames() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(5);
    game.roll(5);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|", actualScoreSheet.getLine2());
    assertEquals("|  5|/|", actualScoreSheet.getLine3());
    assertEquals("|     |", actualScoreSheet.getLine4());
    assertEquals("|-----|", actualScoreSheet.getLine5());

  }

  @Test
  public void testSpareWithSingleFrame() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(5);
    game.roll(5);
    game.roll(1);
    game.roll(1);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|", actualScoreSheet.getLine2());
    assertEquals("|  5|/|  1|1|", actualScoreSheet.getLine3());
    assertEquals("|  11 |  13 |", actualScoreSheet.getLine4());
    assertEquals("|-----|-----|", actualScoreSheet.getLine5());

  }


  @Test
  public void testStrikeAndSpareWithThreeFrames() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(10);
    game.roll(9);
    game.roll(1);
    game.roll(1);
    game.roll(1);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|", actualScoreSheet.getLine2());
    assertEquals("|   |X|  9|/|  1|1|", actualScoreSheet.getLine3());
    assertEquals("|  20 |  31 |  33 |", actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|", actualScoreSheet.getLine5());

  }

  @Test
  public void testThreeFrames() {
    //create a single game with one frame
    Game game = new Game();
    game.roll(1);
    game.roll(2);
    game.roll(3);
    game.roll(4);
    game.roll(5);
    game.roll(4);

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|", actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|", actualScoreSheet.getLine2());
    assertEquals("|  1|2|  3|4|  5|4|", actualScoreSheet.getLine3());
    assertEquals("|  3  |  10 |  19 |", actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|", actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFrames() {
    //create a single game with one frame
    Game game = new Game();
    for (int i = 0; i < 20; i++) {
      game.roll(1);
    }

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1| 1|1|0|",
        actualScoreSheet.getLine3());
    assertEquals("|  2  |  4  |  6  |  8  |  10 |  12 |  14 |  16 |  18 |   20 |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFramesWithOneThrowRemaining() {
    //create a single game with one frame
    Game game = new Game();
    for (int i = 0; i < 19; i++) {
      game.roll(1);
    }

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1| 1|0|0|",
        actualScoreSheet.getLine3());
    assertEquals("|  2  |  4  |  6  |  8  |  10 |  12 |  14 |  16 |  18 |      |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFramesNoScores() {
    //create a single game with one frame
    Game game = new Game();
    for (int i = 0; i < 20; i++) {
      game.roll(0);
    }

    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  0|0|  0|0|  0|0|  0|0|  0|0|  0|0|  0|0|  0|0|  0|0| 0|0|0|",
        actualScoreSheet.getLine3());
    assertEquals("|  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   0  |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFramesLastFourThrowsStrike() {
    //create a single game with one frame
    Game game = new Game();
    for (int i = 0; i < 16; i++) {
      game.roll(1);
    }
    game.roll(10);
    game.roll(10);
    game.roll(10);
    game.roll(10);
    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|   |X| X|X|X|",
        actualScoreSheet.getLine3());
    assertEquals("|  2  |  4  |  6  |  8  |  10 |  12 |  14 |  16 |  46 |   76 |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFramesWithLastFrameTwoStrikesOnly() {
    Game game = new Game();
    for (int i = 0; i < 16; i++) {
      game.roll(1);
    }
    game.roll(10);
    game.roll(10);
    game.roll(10);
    game.roll(5);
    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|   |X| X|X|5|",
        actualScoreSheet.getLine3());
    assertEquals("|  2  |  4  |  6  |  8  |  10 |  12 |  14 |  16 |  46 |   71 |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFramesWithLastFrameSingleStrike() {
    Game game = new Game();
    for (int i = 0; i < 18; i++) {
      game.roll(1);
    }
    game.roll(10);
    game.roll(5);
    game.roll(4);
    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1| X|5|4|",
        actualScoreSheet.getLine3());
    assertEquals("|  2  |  4  |  6  |  8  |  10 |  12 |  14 |  16 |  18 |   37 |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

  @Test
  public void testTenFramesLastTwoFramesWithSpares() {
    //create a single game with one frame
    Game game = new Game();
    for (int i = 0; i < 16; i++) {
      game.roll(1);
    }
    game.roll(9);
    game.roll(1);
    game.roll(5);
    game.roll(5);
    game.roll(5);
    Scoresheet actualScoreSheet = ScoresheetPrinter.generateScoreSheet(game);

    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine1());
    assertEquals("|--1--|--2--|--3--|--4--|--5--|--6--|--7--|--8--|--9--|--10--|",
        actualScoreSheet.getLine2());
    assertEquals("|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  1|1|  9|/| 5|/|5|",
        actualScoreSheet.getLine3());
    assertEquals("|  2  |  4  |  6  |  8  |  10 |  12 |  14 |  16 |  31 |   46 |",
        actualScoreSheet.getLine4());
    assertEquals("|-----|-----|-----|-----|-----|-----|-----|-----|-----|------|",
        actualScoreSheet.getLine5());

  }

}