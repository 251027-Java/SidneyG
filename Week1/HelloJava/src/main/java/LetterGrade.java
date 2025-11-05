import java.util.Scanner;

public class LetterGrade {
    public static void main() {
        /*
        //My Solution
        double myGrade;
        Scanner scanner = new Scanner(System.in);

        // or myGrade = console.readLine();
        try {
            IO.println("Enter Your Grade: ");
            myGrade = scanner.nextDouble();
        } catch (Exception e) {
            IO.println("Your grade was not entered correctly!");
            myGrade = 0;
        }


        if (myGrade >= 100){
            IO.println("Invalid Number");
        } else if (myGrade >= 90) {
            IO.println("A");
        } else if (myGrade >= 80) {
            IO.println("B");
        } else if (myGrade >= 70) {
            IO.println("C");
        } else if (myGrade >= 60) {
            IO.println("D");
        } else if (myGrade >= 0) {
            IO.println("F");
        } else {
            IO.println("Invalid Number");
        }*/

        //Given Solution
        Scanner scanner = new Scanner(System.in);
        double grade = -1;
        boolean invalidInput = true;

        while (invalidInput){
            try {
                System.out.println("Please enter a score between 0 and 100:");
                grade = scanner.nextDouble();
                if (( grade <= 100 ) && ( grade >= 0 )) {
                    invalidInput = false;
                } else {
                    System.out.println("Value was out of range, please try again.");
                }
            } catch (Exception e) {
                System.out.println("That wasn't a number!");
                scanner.next();
            }
        }
        scanner.close();

        System.out.println(grade);

        if (grade < 60 ) {
            IO.println("F");
        } else if (grade < 70) {
            IO.println("D");
        } else if (grade < 80) {
            IO.println("C");
        } else if (grade < 90) {
            IO.println("B");
        } else {
            IO.println("A");
        }

    }
}
