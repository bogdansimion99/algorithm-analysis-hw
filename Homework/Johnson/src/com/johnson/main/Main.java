package com.johnson.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import com.johnson.algorithm.Johnson;
import com.johnson.algorithm.Edge;
import com.johnson.inputOutput.InputReader;
import com.johnson.inputOutput.OutputWriter;

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
        distances = Johnson.getInstance().algo(cost);
        OutputWriter.getInstance().write(outputFile, distances);
    }
}
