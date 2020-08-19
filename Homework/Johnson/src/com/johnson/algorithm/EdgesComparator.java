package com.johnson.algorithm;

import javafx.util.Pair;
import java.util.Comparator;

//this is a comparator for implementing the priority queue
public class EdgesComparator implements Comparator<Pair<Pair<Integer, Integer>, Integer>> {
    @Override
    public int compare(Pair<Pair<Integer, Integer>, Integer> o1, Pair<Pair<Integer, Integer>,
            Integer> o2) {
        return o1.getValue() - o2.getValue();
    }
}
