import java.util.Scanner;
public class HelloJava {


    // fields/ properties

    // methods/ behaviors


    //your application will start form the "entrypoint"
    // which defaults to the main method


    public static void main(String[] args) {
        // We Have to begin with a hello world, it's a necessity, not a choice.
        System.out.println("Hello Java!");
        IO.println("Hello Again!");

        //numerical types
        // declare a variable by type and name,
        // initialize a variable by assigning a value

        // assign
        int myint = 34; // integer values
        double myDouble;//decimal values
        myDouble = 34.5;

        myint = 35;

        // Operators (mathmatical : -, +, *, /, %)
        myint = 34 - 35; // reinitializing


       // Logical /comparison operators: >, <, ==, >=, <=, !=
        boolean myBool = myDouble > myint;
        // boolean can store True, False

        myBool = true;
        myBool = false;

        /*
        float; //floating point decimal
        long; //BIG integer value
        short; // small integer value
        byte; //REALLY small integer values

        // non-numerical types
        char; // character (letters, numbers, punctuation, etc.)
        String; // an array of characters ie words, sentences, etc
        boolean; // true/false value
        void; // seen mostly as a return type, denotes a nothing
        null; // it's not a zero, it's an absence of value
        */


        // Control flow covers all of the keywords and functionality that allow an application
        // to make a decision, and act on it without us providing additional input

        // if, else if, else
        // switch, case
        // for, while, do-while
        // "exception handling" try, catch

        // pseudo-code - describe the logic of your plan, don't worry about the exact syntax

        // initialize a boolean
        myBool = false;

        // make a choice based on the boolean
        // if it's true, do A
        if(myBool != true){
            IO.println("myBool was true");
        } else {
            // if it's false, do B
            IO.println("myBool was false!");
        }



    }
}
