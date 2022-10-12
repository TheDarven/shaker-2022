package fr.thedarven.shaker2022;

import java.util.Scanner;

public class Problem5 {

    public static int[][] recettes;
    public static int nbRecettes;
    public static int[] solution;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nbBaies = new int[3];

        String[] splitLine = sc.nextLine().split(" ");
        for (int i = 0; i < 3; i++) {
            nbBaies[i] = Integer.parseInt(splitLine[i]);
        }

        nbRecettes = Integer.parseInt(sc.nextLine());
        recettes = new int[nbRecettes][4];

        for (int i = 0; i < nbRecettes; i++) {
            splitLine = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                recettes[i][j] = Integer.parseInt(splitLine[j]);
            }
        }

        int sol = solve(0, nbBaies[0], nbBaies[1], nbBaies[2]);
        System.out.println(sol);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public static int solve(int recetteIndex, int nbA, int nbB, int nbC) {
        if (recetteIndex == nbRecettes) {
            solution = new int[nbRecettes];
            return 0;
        }

        boolean canBeApplied = recettes[recetteIndex][0] <= nbA
                && recettes[recetteIndex][1] <= nbB
                && recettes[recetteIndex][2] <= nbC;

        int countNext = solve(recetteIndex + 1, nbA, nbB, nbC);

        if (canBeApplied) {
            int[] copySolution = solution.clone();

            int countRecette =  recettes[recetteIndex][3] + solve(recetteIndex,
                    nbA - recettes[recetteIndex][0],
                    nbB - recettes[recetteIndex][1],
                    nbC - recettes[recetteIndex][2]);
            if (countNext > countRecette) {
                solution = copySolution;
                return countNext;
            } else {
                solution[recetteIndex] += 1;
                return countRecette;
            }
        }
        return countNext;
    }
}
