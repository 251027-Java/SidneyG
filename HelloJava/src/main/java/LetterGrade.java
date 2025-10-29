import java.util.Scanner;


public class LetterGrade {
    public static void main() {
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
        }
    }
}
