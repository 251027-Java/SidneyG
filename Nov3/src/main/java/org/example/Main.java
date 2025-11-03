package org.example;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

//As a user, I want to track my responses soo that I can build/submit an expense report at the end of the week.
//As a user, I need to include the date, value, and merchant to include on my expense report.//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

public class Main {
    //Fields

    //Methods
    static void main() {
        List<Expense> expenses = new ArrayList<Expense>();

        System.out.println("Creating a test expense:");
        //Expense myExpense = new Expense(1, new Date() , 99.95, "Walmart"); //call new Date() as a parameter
        expenses.add(new Expense(1, new Date() , 99.95, "Walmart")); //make new object directly in parameter
        expenses.add(new Expense(2, new Date() , 85.75, "Costco"));
        expenses.add(new Expense(3, new Date() , 10000, "Private Jet"));

        System.out.println(expenses);

        System.out.println("Expense Tracker Closing...");
    }
}
