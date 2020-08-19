package com.floyd.inputOutput;

import java.util.Scanner;

public class InputReader {
    private static InputReader instance = null;

    private InputReader() {}

    public static InputReader getInstance() {
        if(instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    public int[][] read(Scanner sc, int vertices) {
        int[][] cost = new int[vertices][vertices];
        boolean[][] isCost = new boolean[vertices][vertices];
        while (sc.hasNextInt()) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            cost[start - 1][finish - 1] = sc.nextInt();
            isCost[start - 1][finish - 1] = true;
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (cost[i][j] == 0 && i != j && !isCost[i][j]) {
                    cost[i][j] = Integer.MAX_VALUE / 2;
                } else if(i == j) {
                    cost[i][j] = 0;
                }
            }
        }
        return cost;
    }
}
