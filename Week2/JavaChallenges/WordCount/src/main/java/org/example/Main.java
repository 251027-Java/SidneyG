package org.example;
//Count how many words start with a vowel
//Function main should take a string sentence as input and return an integer representing the count of
//words that begin with a vowel
//The Sentence only contains alphabetic character and spaces and will only consist of a single line
//a string sentence representing the sentence to analyze


import java.util.*;

// main class
class Main {
    //some method to execute
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        String sentence = scanner.nextLine();
//        String[] words = sentence.split(" ");
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        //create a variable to hold the count of vowels
        int vowelCount = 0;

        //Start a loop to scan in each word of the sentence
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (vowels.contains(word.charAt(0))) {
                vowelCount++;
            }
        }
        scanner.close();

        System.out.println(vowelCount);

        System.out.println(args[0]);

    }
}