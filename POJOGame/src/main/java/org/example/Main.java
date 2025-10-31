package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        IO.println("Hello and Welcome!");

        GameService gameService =  new GameService();
        gameService.start();

        IO.println("Thanks for playing!");

        }
}
