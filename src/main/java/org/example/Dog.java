package org.example;

public class Dog {
    // fields
    private String name = "Rex";
    private String breed = "Irish Setters";
    private int age = 1;
    //use setter and getters to modify these


    //Constructors
    //Java will choose which one to use depending on the parameters the function is being given
    public Dog() {}// this works because the fields were set
    public Dog(String name, String breed, int age){
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
    /*Dog() {
        name = "Rex";
        breed = "Irish Setter";
        age = 1;
    } Default constructor: this will hard code the dog attributes*/

    //method
    void Speak(){
        System.out.println("WoOOOOooooOOOOf!");
    }
    void Walk(){
        System.out.println("Go for a walk!");
    }
    private void GetOlder(){
        age += 7; // age = age + 7
    }

    //getters
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

}
