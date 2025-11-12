/*
Signal Light:
    On a street, you notice that there was a light signal whose color changes from Red to Green in 1 minute, Green to Blue in 1 minute, and Blue to Red in 1 minute.
    Similarly, you are given a string S where each character denotes the initial color of the light signal and an integer K.
    You have to print the final states of all the light signals after K minutes.

Note:
    String S will contain only "R", "G", and "B" characters.
    R in string denotes Red Color.
    G in string denotes Green Color.
    B in string denotes Blue Color.

Function Description:
    In the provided code snippet, implement the provided method RGBLight() to print the final states of lights signals after K minutes. You can write your code in the space below the phrase “WRITE YOUR LOGIC HERE”.

    There will be multiple test cases running so the Input and Output should match exactly as provided.
    The base Output variable result is set to a default value of -404 which can be modified. Additionally, you can add or remove these output variables.

Input Format:
    The first line will contain String S.
    The second line will contain integer K.

Sample Input:
RBRG
2

Constraints:
1 <= length(S) <= 103
1 <= K <= 106

Output Format:
Print a String denoting the final state of all the light signals after K minutes.

Sample Output:
BGBR

Explanation:
    S = RBRG
    After 2 minutes, the light signals with color R will change to color B.
    Light signals with color G will change to color R.
    Light signals with color B will change to color G.
    Hence, the final state will be BGBR.
 */

package org.example;

import java.util.*;


public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        String lights = sc.nextLine();
        lights = lights.toUpperCase();
        int minutes = sc.nextInt() % 3;

        int lightLength = lights.length();

        if (minutes == 0) {
            System.out.println(lights);
            return;
        }

        StringBuilder out = new StringBuilder(lights.length());
        for (int i = 0; i < lights.length(); i++) {
            char c = lights.charAt(i);
            char next;

            if (minutes == 1) {
                // one step: R->G, G->B, B->R
                if (c == 'R') next = 'G';
                else if (c == 'G') next = 'B';
                else /* c == 'B' */ next = 'R';
            } else { // shift == 2
                // two steps: R->B, G->R, B->G
                if (c == 'R') next = 'B';
                else if (c == 'G') next = 'R';
                else /* c == 'B' */ next = 'G';
            }
            out.append(next);
        }
        System.out.println(out.toString());
    }
}
