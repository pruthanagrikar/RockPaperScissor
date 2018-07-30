package com.prutha;

import java.util.HashMap;
import java.util.Map;

public enum Choices {

    ROCK , PAPER , SCISSOR;

    private static Map<Choices, Choices> choiceBeatsChoice = new HashMap<>(){
        {
            put(ROCK, SCISSOR);
            put(PAPER, ROCK);
            put(SCISSOR, PAPER);
        }
    };

    public int isStrongerThan(Choices other){
        if(this == other){
            return 0;
        }else if(choiceBeatsChoice.get(this) == other){
            return 1;
        }
        return -1;
    }
}
