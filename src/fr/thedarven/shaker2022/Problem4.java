package fr.thedarven.shaker2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        int N;
        Node[][] map;
        int xKey = 0, yKey = 0;

        N = Integer.parseInt(sc.nextLine());
        map = new Node[N][N];
        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            int indexKey = line.indexOf('O');
            if (indexKey > -1) {
                xKey = indexKey;
                yKey = i;
            }
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map[i][j] = new Node(j, i, chars[j] == 'X' ? 1 : 0, chars[j] == '0');
            }
        }

        Node.toBeTreated.add(map[0][0]);
        map[0][0].distance = 0;

        while (!Node.toBeTreated.isEmpty()) {
            Node node = Node.toBeTreated.get(0);
            node.setTreated(true);
            Node nodeA;
            if (node.x > 0) {
                nodeA = map[node.y][node.x -1];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
            if (node.x < N - 1) {
                nodeA = map[node.y][node.x +1];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
            if (node.y > 0) {
                nodeA = map[node.y - 1][node.x];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
            if (node.y < N - 1) {
                nodeA = map[node.y + 1][node.x];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
        }

        int distance = map[yKey][xKey].distance;

        Node.toBeTreated.add(map[yKey][xKey]);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j].distance =Integer.MAX_VALUE;
            }
        }
        map[yKey][xKey].distance = 0;

        while (!Node.toBeTreated.isEmpty()) {
            Node node = Node.toBeTreated.get(0);
            node.setTreated(true);
            Node nodeA;
            if (node.x > 0) {
                nodeA = map[node.y][node.x -1];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
            if (node.x < N - 1) {
                nodeA = map[node.y][node.x +1];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
            if (node.y > 0) {
                nodeA = map[node.y - 1][node.x];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
            if (node.y < N - 1) {
                nodeA = map[node.y + 1][node.x];
                if (nodeA.weight + node.distance < nodeA.distance) {
                    Node.toBeTreated.add(nodeA);
                    nodeA.distance = nodeA.weight + node.distance;
                }
            }
        }

        System.out.println(distance + map[N - 1][N - 1].distance);
    }

    public static class Node {
        public static List<Node> toBeTreated = new ArrayList<>();

        int x;
        int y;
        int weight;
        boolean isKey;
        boolean isTreated = false;
        int distance = Integer.MAX_VALUE;

        public Node(int x, int y, int weight, boolean isKey) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.isKey = isKey;
        }

        public void setTreated(boolean treated) {
            isTreated = treated;
            if (isTreated) {
                Node.toBeTreated.remove(this);
            } else {
                Node.toBeTreated.add(this);
            }
        }
    }
}
