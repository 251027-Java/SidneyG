package org.example;
/*
system maintains  a list of book isbns sorted in ascending order and eas is unique

when user searches for a book if it exists return its index
if not return the index where the new ISBN should be inserted to maintain the order

input:
single integer n - the number of isbns in the list


 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // read the input
        Scanner scanner = new Scanner(System.in);
            // first input os the number of ISBNs
        int N = scanner.nextInt();
            // create some integer to hold the number of ISBNs

            // a space separated list of the ISBNs
            // create an integer array to hold all of the ISBNs
        int[] isbns = new int[N];
        // scanner.nextLine().split().map( i -> Integer.parseInt(i)); who knows, maybe?
        for ( int i = 0; i < N; i++) {
            isbns[i] = scanner.nextInt();
        }

            // the target_ISBN
            // create another integer for the target_ISBN
        int target_ISBN = scanner.nextInt();

        if ( target_ISBN > isbns[N-1]) {
            System.out.println(N);
            return;
        }
        // find the target_ISBN position in the list of ISBNs (by binary search)
        // Use an iterated/for loop to search through the list of ISBNs
        for (int i = 0; i < N; i++) {
            // is the target_ISBN less than the current list_ISBN?
            if (target_ISBN <= isbns[i]) {
                System.out.println(i);
                return;
            }
        }
//            } else if (target_ISBN > isbns[i]){
//
//            } else if (target_ISBN == isbns[i]) {
//                System.out.println(i);
//                return;
//            }

                // YES: we've gone too far,
                // NO: is the current item the target_ISBN?
            // is the current item SMALLER than the target?
            // is the current item the target?



            // if the target_ISBN is NOT on the list, grab the index/position where it should
        // print out the position of the target_ISBN

    }
}
