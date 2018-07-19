package com.prutha;

import java.util.HashMap;
import java.util.Map;

import static com.prutha.Choices.*;

public class Game {

     private static int MAXIMUM_ROUNDS_ALLOWED = 100;
     private int numberOfRounds;
     private Player player1;
     private Player player2;


    Game(Player player1, Player player2) throws GameException{
        System.out.println("Game has been started! Best of LUCK!");

        this.numberOfRounds = 0;

        if(player1==null || player2==null ) {
            throw new GameException("Sorry! The Game needs exactly two players!");
        }

        this.player1 = player1;
        this.player2 = player2;
    }

   public void play() throws GameException{

       if(!validChoice()){
           throw new GameException("make a valid choice");
       }

       numberOfRounds = numberOfRounds + 1;

       if(numberOfRounds>MAXIMUM_ROUNDS_ALLOWED){
           throw new GameException("Sorry! you cant play for more than 100 times");
       }

       processMove();

   }

   public void processMove(){

       Map<Choices, Choices> choiceBeatsChoice = new HashMap<>();

       choiceBeatsChoice.put(ROCK,SCISSOR);
       choiceBeatsChoice.put(PAPER,ROCK);
       choiceBeatsChoice.put(SCISSOR,PAPER);

       if(player1.getCurrentChoice() == player2.getCurrentChoice()){
           System.out.println("Ahh, its a draw for round : " + getNumberOfRounds());
       }

       choiceBeatsChoice.forEach((k, v) -> {
           if(k == player1.getCurrentChoice() && v == player2.getCurrentChoice()){
               player1.incrementScore();
               printResultForMove(player1);
               return;
           }else if(k == player2.getCurrentChoice() && v == player1.getCurrentChoice() ) {
               player2.incrementScore();
               printResultForMove(player2);
               return;
           }
       });

   }

   public Player getWinner(){
        return ( player1.getScore() > player2.getScore() ) ? player1 : player2 ;
   }

   public void printResultForMove(Player winner){
       System.out.println("Winner for round: " + getNumberOfRounds() + " is: " + winner.getName());
   }

   public boolean validChoice(){
        boolean isValid = false;
        if(player1.getCurrentChoice()!=null || player2.getCurrentChoice()!=null){
            isValid = true;
        }
        return isValid;
   }

   public int getNumberOfRounds(){
        return this.numberOfRounds;
   }

}
