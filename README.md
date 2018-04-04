# Bowling Kata

Hosted on [GitHub](https://github.com/joemckevitt/bowling-kata)

[![Build Status](https://travis-ci.org/joemckevitt/bowling-kata.svg?branch=master)](https://travis-ci.org/joemckevitt/bowling-kata)

## Bowling Rules
The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.


A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.


A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.


In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.


## Requirements
Write a class Game that has two methods

`void roll(int)` is called each time the player rolls a ball. The argument is the number of pins knocked down.

`int score()` returns the total score for that game.


### Credit
Inspired by [Uncle Bob](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata)

### Project quality gates
This project uses the following code styles

Google style guide:
[https://code.google.com/p/google-styleguide](https://code.google.com/p/google-styleguide/)

Google check style:
[http://checkstyle.sourceforge.net/google_style.html](http://checkstyle.sourceforge.net/google_style.html)

This project uses the following static analysis tools

FindBugs: 
[http://findbugs.sourceforge.net/](http://findbugs.sourceforge.net/)