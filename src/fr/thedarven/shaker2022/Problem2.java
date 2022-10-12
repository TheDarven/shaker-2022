package fr.thedarven.shaker2022;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        boolean cachette = false;
        int distanceCachette = 0;
        int distanceOurs = 0;

        boolean isPossible = true;

        for (char cara: line.toCharArray()) {
            if (!cachette) {
                if (cara == 'B') {
                    isPossible = false;
                    break;
                } else if (cara == 'C') {
                    cachette = true;
                }
                distanceCachette++;
            } else {
                distanceOurs++;
                if (cara == 'B') {
                    isPossible = distanceOurs > distanceCachette;
                    break;
                }
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }
}
