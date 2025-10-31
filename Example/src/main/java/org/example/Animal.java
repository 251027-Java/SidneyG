package org.example;

public abstract class Animal {
    //Field
    private String name;

    //Constructor
    public Animal (){}

    public Animal (String name) {
        this.name = name;
    }

    //Method
    //This is the default that all classes that extend it will use
    //If we want method to do something else we must @override it
    public void eat() {
        System.out.println("Om nomnom!");
    }

    //We will have to use this method in each class that extends it because it is abstract. We dont have to define the method becuase it will be different each time
    public abstract void makeSound(); //abstract methods are only gonna be available through an abstract class.

}

