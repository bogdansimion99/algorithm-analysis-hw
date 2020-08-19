package com.dijkstra.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import com.dijkstra.algorithm.Dijkstra;
import com.dijkstra.algorithm.Edge;
import com.dijkstra.inputOutput.InputReader;
import com.dijkstra.inputOutput.OutputWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        Scanner sc = new Scanner(inputFile);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        LinkedList<Edge>[] cost;
        cost = InputReader.getInstance().read(sc, vertices);
        int[][] distances = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            distances[i] = Dijkstra.getInstance().algo(cost, i);
        }
        OutputWriter.getInstance().write(outputFile, distances);
    }
}
