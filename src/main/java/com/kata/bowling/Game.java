package com.kata.bowling;

/**
 * http://kata-log.rocks/bowling-game-kata
 * 
 * Bowling Rules
The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. 
The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two rolls. 
The bonus for that frame is the number of pins knocked down by the next roll.

A strike is when the player knocks down all 10 pins on his first roll. 
The frame is then completed with a single roll. 
The bonus for that frame is the value of the next two rolls.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. 
However no more than three balls can be rolled in tenth frame.

Requirements
Write a class Game that has two methods

void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
int score() returns the total score for that game.
 */

public class Game {

    private int currentScore = 0;

    private int numberOfThrows = 0;
    private int numberOfFrames = 0;
    private int lastRoll = 0;
    private boolean endOfFrame;
    private boolean spareInLastFrame;
    
    public void roll(int latestThrow)  {

        System.out.println("-----------------------");
        System.out.println("Score before throw " + currentScore);
        System.out.println("No of pins rolled over in this roll " + latestThrow);
        numberOfThrows++;
        
        //evaluating if its the end of the frame
        if ((numberOfThrows % 2) == 0) 
        {
            numberOfFrames++;
            endOfFrame = true;
        }
        
        if (endOfFrame)   {
            if (lastRoll + latestThrow == 10)   {
                spareInLastFrame=true;
                currentScore = currentScore + 10;
                
                //reset
                endOfFrame=false;
                lastRoll = 0;
            } else  {
                
               if (spareInLastFrame )    {
                   //last frame scored a spare
                   //this time hit two throws without a spare (less then 10)
                   currentScore = currentScore + (2*lastRoll) + latestThrow;
                   
               } else {
                 currentScore = currentScore + latestThrow + lastRoll; 
               }
               
                //reset
                endOfFrame=false;
                lastRoll = 0;
            }
        } else  {
            //cache last throw
            lastRoll = latestThrow;
        }   
        

        
        System.out.println("-----score updated ----");
        System.out.println("Last throw " + lastRoll);
        System.out.println("Current Score " + currentScore);
        System.out.println("No. of throws " + numberOfThrows);
        System.out.println("No. of frames " + numberOfFrames);
        System.out.println("-----------------------");
        
    }

    
    public int score()  {
        return currentScore;
    }
    
    public static void main(String... argvs) {
        String a = "Bowling game";
        System.out.println("Hello World " + a + "!");
    }
}
