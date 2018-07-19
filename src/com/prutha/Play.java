package com.prutha;

import java.util.Random;

public class Play {

    public static void main(String[] args){
        Play play = new Play();

        Game game;
        Player player1 = new Player("Prutha");
        Player player2 = new Player("Niels");

        player1.setCurrentChoice(Choices.ROCK);

        try{
            game = new Game(player1,player2);
            player1.setCurrentChoice(Choices.ROCK);

            for (int count = 0; count <100 ; count++) {
                player2.setCurrentChoice(play.selectRandomly());
                game.play();
            }

            System.out.println("score for " + player1.getName() + " is:" + player1.getScore() );
            System.out.println("score for " + player2.getName() + " is:" + player2.getScore() );

            System.out.println("And the winner is " + game.getWinner().getName());

        } catch (GameException e){
            System.out.println(e.getMessage());
        }


    }

    private Choices selectRandomly(){
        int pick = new Random().nextInt(Choices.values().length);
        return Choices.values()[pick];

    }
}
