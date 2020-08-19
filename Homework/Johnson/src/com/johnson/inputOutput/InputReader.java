package com.johnson.inputOutput;

import com.johnson.algorithm.Edge;

import java.util.LinkedList;
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

    public LinkedList<Edge>[] read(Scanner sc, int vertices) {
        LinkedList<Edge>[] graph = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<>();
        }
        while (sc.hasNextInt()) {
            Edge edge = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
            graph[edge.getStart()].add(edge);
        }
        return graph;
    }
}
