package fr.thedarven.shaker2022;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weight = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < 5; i++) {
            weight -= Integer.parseInt(sc.nextLine());
        }

        System.out.println(weight >= 0 ? "YES" : "NO");
    }
}
