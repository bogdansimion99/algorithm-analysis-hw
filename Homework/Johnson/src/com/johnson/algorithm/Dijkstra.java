package com.johnson.algorithm;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    private static Dijkstra instance = null;

    private Dijkstra() {}

    public static Dijkstra getInstance() {
        if(instance == null) {
            instance = new Dijkstra();
        }
        return instance;
    }

    public int[] algo (LinkedList<Edge>[] graph, int start) {
        int[] distances = new int[graph.length];
        PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> pq = new PriorityQueue<>(new EdgesComparator());
        for (int i = 0; i < graph.length; i++) {
            if (i == start) {
                distances[i] = 0;
                continue;
            }
            distances[i] = Integer.MAX_VALUE / 2;
        }
        for (Edge x: graph[start]) {
            Pair<Integer, Integer> verticesPair = new Pair<>(x.getStart(), x.getFinish());
            Pair<Pair<Integer, Integer>, Integer> pair = new Pair<>(verticesPair, x.getCost());
            pq.add(pair);
        }
        int noVisited = 1;
        int indexOfVertex = start;
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        int[] minimumDistances = new int[graph.length];
        // Implementing Dijkstra's algorithm
        while(noVisited < graph.length) {
            if(pq.size() == 0) {
                break;
            }
            for (Pair<Pair<Integer, Integer>, Integer> x : pq) {
                if (x.getKey().getKey() == indexOfVertex) {
                    for (Edge y: graph[x.getKey().getKey()]) {
                        if(y.getFinish() == x.getKey().getValue()) {
                            minimumDistances[x.getKey().getValue()] = y.getCost();
                        }
                    }
                }
            }
            int nextVertex = -1;
            for (Pair<Pair<Integer, Integer>, Integer> x : pq) {
                nextVertex = x.getKey().getValue();
                if (graph[nextVertex].size() != 0 && !visited[nextVertex]) {
                    visited[nextVertex] = true;
                    break;
                }
                visited[nextVertex] = true;
            }
            noVisited++;
            for (Edge x: graph[indexOfVertex]) {
                Pair<Integer, Integer> pair = new Pair<>(x.getFinish(), x.getCost());
                if ((distances[x.getFinish()] > minimumDistances[x.getFinish()]
                        + distances[x.getStart()])) {
                    distances[x.getFinish()] = minimumDistances[x.getFinish()] + distances[x.getStart()];
                }
            }
            pq.remove(pq.iterator().next());
            indexOfVertex = nextVertex;
            for (Edge x: graph[indexOfVertex]) {
                Pair<Integer, Integer> verticesPair = new Pair<>(x.getStart(), x.getFinish());
                Pair<Pair<Integer, Integer>, Integer> pair = new Pair<>(verticesPair, x.getCost() +
                        minimumDistances[verticesPair.getKey()]);
                pq.add(pair);
            }
        }
        return distances;
    }
}
