package com.education.hszg.graphs.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Point {
    private final String value;
    private List<Point> adjacents = new ArrayList<Point>();
    private Set<Point> reachableFrom = new HashSet<Point>();

    public String getValue() {
        return value;
    }

    public List<Point> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(List<Point> adjacents) {
        this.adjacents = adjacents;
    }

    public Set<Point> getReachableFrom() {
        return reachableFrom;
    }

    public void setReachableFrom(Set<Point> reachableFrom) {
        this.reachableFrom = reachableFrom;
    }
    @Override
    public String toString() {
        return value;
    }

    public void connect(Point end){
        adjacents.add(end);
    }
    public void connect(Point end, boolean directed){
        adjacents.add(end);

        if (!directed){
            end.getAdjacents().add(this);
        }
    }
}
