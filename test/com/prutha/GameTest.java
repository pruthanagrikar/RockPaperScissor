package com.prutha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameTest{

    private Game game;
    Player player1 = new Player("Prutha");
    Player player2 = new Player("Niels");

    @BeforeEach
    public void setUp() throws GameException {

        player1.setCurrentChoice(Choices.ROCK);
        player2.setCurrentChoice(Choices.PAPER);

        game = new Game(player1,player2);
    }

    @Test
    public void shouldPlayGame() throws GameException {

        game.play();

        assertEquals(game.getNumberOfRounds(),1);
    }

    @Test
    public void shouldPlayGameFor100Times() throws GameException {
        for (int count = 0; count < 100; count++) {
            game.play();
        }

        assertEquals(game.getNumberOfRounds() , 100);
    }

    @Test
    public void shouldNotAllowToPlayForMoreThan100(){

        assertThrows(GameException.class, ()->{

            for (int count = 0; count < 101; count++) {
                game.play();
            }
        });
    }

    @Test
    public void rockShouldBeatScissor() throws GameException {
        player1.setCurrentChoice(Choices.ROCK);
        player2.setCurrentChoice(Choices.SCISSOR);

        game.play();

        assertEquals(game.getWinner().getName(), player1.getName());
    }

    @Test
    public void scissorShouldBeatPaper() throws GameException {

        player1.setCurrentChoice(Choices.PAPER);
        player2.setCurrentChoice(Choices.SCISSOR);

        game.play();

        assertEquals(game.getWinner().getName(), player2.getName());
    }


    @Test
    public void paperShouldBeatRock() throws GameException {

        player1.setCurrentChoice(Choices.PAPER);
        player2.setCurrentChoice(Choices.ROCK);

        game.play();

        assertEquals(game.getWinner().getName(), player1.getName());
    }

}