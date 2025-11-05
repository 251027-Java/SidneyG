package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Dog dog = new Dog("Rex");
        Cat cat = new Cat();
        Bird bird = new Bird();

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();

        cat.eat();
        dog.eat();

        cat.giveBirth();
        dog.giveBirth();

    }
}
