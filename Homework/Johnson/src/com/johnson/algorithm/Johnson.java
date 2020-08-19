package com.johnson.algorithm;

import java.util.LinkedList;

public class Johnson {
    private static Johnson instance = null;

    private Johnson() {}

    public static Johnson getInstance() {
        if (instance == null) {
            instance = new Johnson();
        }
        return instance;
    }

    public int[][] algo (LinkedList<Edge>[] graph) {
        int[][] distances = new int[graph.length][graph.length];
        boolean negative = false;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                    break;
                }
                distances[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (Edge x: graph[i]) {
                if(x.getCost() < 0) {
                    negative = true;
                    break;
                }
            }
            if (negative) {
                break;
            }
        }
        int min = 0;
        for (int i = 0; i < graph.length; i++) {
            for (Edge x: graph[i]) {
                if (min > x.getCost()) {
                    min = x.getCost();
                }
            }
        }
        // Implements Bellman - Ford algorithm
        int[] newDistances = new int[graph.length];
        if (negative) {
            LinkedList<Edge>[] newGraph = new LinkedList[graph.length + 1];
            for (int i = 0; i <= graph.length; i++) {
                newGraph[i] = new LinkedList<>();
            }
            //newGraph = graph;
            for (int i = 0; i < graph.length; i++) {
                newGraph[i] = graph[i];
            }
            for (int i = 0; i < graph.length; i++) {
                Edge e = new Edge(graph.length, i, 0);
                newGraph[graph.length].add(e);
            }
            // O(V*E) complexity
            for (int k = 1; k < graph.length; k++) {
                for (int i = 0; i < graph.length; i++) {
                    for (Edge x: graph[i]) {
                        if (newDistances[i] != Integer.MAX_VALUE / 2 && newDistances[x.getFinish()]
                                > newDistances[i] + x.getCost()) {
                            newDistances[x.getFinish()] = newDistances[i] + x.getCost();
                        }
                    }
                }
            }
            // Check for negative-weight cycles
            for (int i = 0; i < graph.length; i++) {
                for (Edge x: graph[i]) {
                    if (newDistances[i] != Integer.MAX_VALUE / 2 && newDistances[x.getFinish()]
                            > newDistances[i] + x.getCost()) {
                        System.out.println("Graph has negative-weight cycles!");
                        System.out.println("The algorithm returns wrong values." + " " +
                                "Problem not decidable.");
                        System.exit(1);
                    }
                }
            }
            for (int i = 0; i < graph.length; i++) {
                for (Edge x: graph[i]) {
                    x.setCost(x.getCost() + newDistances[x.getStart()] - newDistances[x.
                            getFinish()]);
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            distances[i] = Dijkstra.getInstance().algo(graph, i);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j || distances[i][j] == Integer.MAX_VALUE / 2) {
                    continue;
                }
                distances[i][j] += newDistances[j] - newDistances[i];
            }
        }
        return distances;
    }
}
