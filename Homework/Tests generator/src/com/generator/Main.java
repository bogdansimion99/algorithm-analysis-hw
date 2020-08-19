package com.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Random rand = new Random();
        // Number of vertices and edges. I generated them manually or with rand.
        int noVertices = 100;
        int noEdges = rand.nextInt(noVertices * noVertices);
        System.out.println(noEdges);
        // The matrix of costs. I generated each cost with rand following some rules.
        int[][] costs = new int[noEdges][3];
        for (int i = 0; i < noEdges; i++) {
            costs[i][0] = rand.nextInt(noVertices) + 1;
            costs[i][1] = rand.nextInt(noVertices) + 1;
            costs[i][2] = rand.nextInt(100) - 1;
            if (costs[i][0] == costs[i][1]) {
                i--;
            } else {
                for (int j = 0; j < i; j++) {
                    if (costs[i][0] == costs[j][0] && costs[i][1] == costs[j][1]) {
                        i--;
                        break;
                    }
                }
            }
        }
        // In the new file specified I put the test format
        File outputFile = new File("F:\\Documente_Bogdan\\Facultate\\AA\\Tema\\" + "test4.in");
        PrintWriter print = new PrintWriter(outputFile);
        print.print(noVertices + " ");
        print.print(noEdges);
        print.println();
        for (int i = 0; i < noEdges; i++) {
            print.print(costs[i][0] + " ");
            print.print(costs[i][1] + " ");
            print.print(costs[i][2] + " ");
            print.println();
        }
        print.close();
    }
}
