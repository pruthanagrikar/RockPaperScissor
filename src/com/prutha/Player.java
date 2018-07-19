package com.prutha;

public class Player {

    private String name;
    private Choices currentChoice;
    private int score;

    Player(String name){
        this.name = name;
        score = 0;
    }

    public Choices getCurrentChoice() { return currentChoice; }
    public String getName() { return name; }
    public void setCurrentChoice(Choices currentChoice) { this.currentChoice = currentChoice; }
    public int getScore() { return score; }
    public void incrementScore() { score++; }
}
