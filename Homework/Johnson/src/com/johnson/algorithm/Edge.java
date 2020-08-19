package com.johnson.algorithm;

public class Edge {
    private int start;
    private int finish;
    private int cost;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Edge () {
        this.start = 0;
        this.finish = 0;
        this.cost = 0;
    }

    public Edge (int start, int finish, int cost) {
        this.start = start;
        this.finish = finish;
        this.cost = cost;
    }
}

