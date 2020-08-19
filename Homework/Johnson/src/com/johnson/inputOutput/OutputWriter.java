package com.johnson.inputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputWriter {
    private static OutputWriter instance = null;

    private OutputWriter() {}

    public static OutputWriter getInstance() {
        if(instance == null) {
            instance = new OutputWriter();
        }
        return instance;
    }

    public void write (File outputFile, int[][] distances) throws FileNotFoundException {
        PrintWriter print = new PrintWriter(outputFile);
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                if(distances[i][j] == Integer.MAX_VALUE / 2) {
                    print.print("inf ");
                    continue;
                }
                print.print(distances[i][j] + " ");
            }
            print.println();
        }
        print.close();
    }
}
