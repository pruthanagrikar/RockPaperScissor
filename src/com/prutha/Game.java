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

       int strongerThan = player1.getCurrentChoice().isStrongerThan(player2.getCurrentChoice());

       if(strongerThan ==0){
           System.out.println("Ahh, its a draw for round : " + getNumberOfRounds());
       }else if(strongerThan > 0){
           player1.incrementScore();
           printResultForMove(player1);
       }else {
           player2.incrementScore();
           printResultForMove(player2);
       }

   }

   public Player getWinner(){
        return ( player1.getScore() > player2.getScore() ) ? player1 : player2 ;
   }

   private void printResultForMove(Player winner){
       System.out.println("Winner for round: " + getNumberOfRounds() + " is: " + winner.getName());
   }

   private  boolean validChoice(){
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
