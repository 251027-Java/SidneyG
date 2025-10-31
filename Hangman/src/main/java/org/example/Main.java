package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() { //the main method is the one that will be executed
        Dog pupper = new Dog(); // creating an instance
        pupper.Speak();
        pupper.Walk();
        IO.println(pupper.getName());

        //we will no longer be able to use this method directly in main now that the method is private
        /* pupper.GetOlder();
        pupper.GetOlder();
        pupper.GetOlder();
        pupper.GetOlder();
        pupper.GetOlder(); //nothing from stopping this method being run over and over in main */

        //pupper.name = "Pupperoni"; //we cannot do this because name is private
        //System.out.println(pupper.name); //we cannot do this because name is private

        Dog minnie = new Dog("Minnie", "Maltize", 5);
        minnie.Speak();
        IO.println(minnie.getName());
        minnie.setName("Maxi");
        IO.println(minnie.getName());
    }
}


/*
METHODS
we will put things we will use later in a method
we would make a method when we have a behavior that has a specific action that will handle something
    we could put this into its own method
we get a main method right off the bat
a method will run whenever its called
a class contains methods, fields/vals/properties/algorithms

create a new file myClass
 */