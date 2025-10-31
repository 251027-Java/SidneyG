package org.example;

public class myClass {
    //fields
    public int guessesRemaining; //any file can use it
    private char currentGuess; // only that class is able to interact with it
    protected String secretWord; // access from within class or from whatever extends or builds on top of the class
    char[] previousGuesses;
    String hiddenWord;
    String finalGuess;
    int i = 0;

    // methods
    boolean ValidateInput(String userInput){
        return true;
    }
    String DisplayHiddenWord(){
        return "";
    }
    void DecrementGuessesRemaining(){
        i = 1;
    }
    boolean CheckGuess(){
    //I'll add some things here
        i++;

        return false;

    }
    void DisplayGallows(){}
    void DisplayPreviousGuesses(){}
    String UpdateHiddenWord(){
        return "";
    }


}


/*

we need return type and possible access modifiers in order for method to work

SCOPE
what can or cant modify
method scope- aka local scope. Variables declared directly inside a method are available anywhere in the method
 */