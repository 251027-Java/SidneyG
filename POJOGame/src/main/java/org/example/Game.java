package org.example;

import java.util.Random;

public class Game {
    // Fields
    private int secretNumber;

    //Constructor
    public Game(){
        Random randrandom = new Random();
        this.secretNumber = randrandom.nextInt(100) + 1;
    }
    // Methods
    public int getSecretNumber() {
        return this.secretNumber;
    }

}
