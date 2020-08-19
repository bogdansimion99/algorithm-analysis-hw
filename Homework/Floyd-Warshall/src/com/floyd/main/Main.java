package com.floyd.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.floyd.algorithm.FloydWarshall;
import com.floyd.inputOutput.InputReader;
import com.floyd.inputOutput.OutputWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        Scanner sc = new Scanner(inputFile);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        int[][] cost;
        cost = InputReader.getInstance().read(sc, vertices);
        int[][] distances;
        distances = FloydWarshall.getInstance().algo(cost);
        OutputWriter.getInstance().write(outputFile, distances);
    }
}
