package com.floyd.algorithm;

public class FloydWarshall {
    private static FloydWarshall instance = null;

    private FloydWarshall() {}

    public static FloydWarshall getInstance() {
        if(instance == null) {
            instance = new FloydWarshall();
        }
        return instance;
    }

    public int[][] algo (int[][] cost) {
        int[][] distances = cost;
        for (int k = 0; k < cost.length; k++) {
            // k is the intermediate vertex
            for (int i = 0; i < cost.length; i++) {
                // i is the starting vertex
                for (int j = 0; j < cost.length; j++) {
                    // j is the ending vertex
                    if(distances[i][k] != Integer.MAX_VALUE / 2 && distances[k][j] != Integer.
                            MAX_VALUE / 2) {
                        if (distances[i][j] > distances[i][k] + distances[k][j]) {
                            distances[i][j] = distances[i][k] + distances[k][j];
                        }
                    }
                }
            }
        }
        return distances;
    }
}
