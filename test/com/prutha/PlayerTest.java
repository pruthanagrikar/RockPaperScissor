package com.prutha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerTest {

    Player player;
    public static final String NAME = "Prutha";

    @BeforeEach
    public void setUp(){
        player = new Player(NAME);
    }


    @Test
    public void shouldCreatePlayersWithZeroScoreAndNoChoice(){
        assertEquals(player.getName(), NAME);
        assertEquals(player.getScore(), 0);
        assertNull(player.getCurrentChoice());
    }

    @Test
    public void shouldSetChoice(){
        player.setCurrentChoice(Choices.SCISSOR);

        assertEquals(player.getCurrentChoice(), Choices.SCISSOR);
    }

    @Test
    public void shouldIncrementScore(){
        assertEquals(player.getScore(), 0);

        player.incrementScore();
        assertEquals(player.getScore(), 1);

        player.incrementScore();
        assertEquals(player.getScore(), 2);
    }


}
