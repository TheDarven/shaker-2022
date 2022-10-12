package fr.thedarven.shaker2022;

import java.util.*;

public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Star[] constellation = new Star[3];
        int N;
        Star[] stars;

        for (int i = 0; i < 3; i++) {
            String[] coords = sc.nextLine().split(" ");
            constellation[i] = new Star(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
        }

        N = Integer.parseInt(sc.nextLine());
        stars = new Star[N];
        Map<Integer, List<Star>> xMap = new HashMap<>();
        Map<Integer, List<Star>> yMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] coords = sc.nextLine().split(" ");
            stars[i] = new Star(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));

            List<Star> xStars = xMap.get(stars[i].x);
            if (xStars == null) {
                xStars = new ArrayList<>();
                xMap.put(stars[i].x, xStars);
            }
            xStars.add(stars[i]);

            List<Star> yStars = yMap.get(stars[i].y);
            if (yStars == null) {
                yStars = new ArrayList<>();
                yMap.put(stars[i].y, yStars);
            }
            yStars.add(stars[i]);
        }

        Star[] findedStar = new Star[3];
        boolean find = false;
        for (Star star: stars) {
            findedStar[0] = star;

            List<Star> xStars = xMap.get(star.x + (constellation[1].x - constellation[0].x));
            List<Star> yStars = yMap.get(star.y + (constellation[1].y - constellation[0].y));
            if (xStars == null || yStars == null) {
                continue;
            }
            Optional<Star> oXStar = xStars.stream()
                    .filter(yStars::contains)
                    .findFirst();
            if (oXStar.isEmpty()) {
                continue;
            }
            findedStar[1] = oXStar.get();

            xStars = xMap.get(star.x + (constellation[2].x - constellation[0].x));
            yStars = yMap.get(star.y + (constellation[2].y - constellation[0].y));
            if (xStars == null || yStars == null) {
                continue;
            }
            oXStar = xStars.stream()
                    .filter(yStars::contains)
                    .findFirst();

            if (oXStar.isEmpty()) {
                continue;
            }
            findedStar[2] = oXStar.get();
            find = true;
            break;
        }

        if (find) {
            for (int i = 0; i < 3; i++) {
                System.out.println(findedStar[i].x + " " + findedStar[i].y);
            }
        } else {
            System.out.println("NOT FOUND");
        }
    }

    public static class Star{

        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
