package com.algorithms.dictionaryStrings;

import java.util.*;

/**
 * Solves tasks of finding the lowest way from string S1 to Sn-1
 * through nearest strings
 * (where string on each step different from previous one just by 1 character)
 */
public class RoadCalculator {
    private static final int STEP = 1;

    private Map<String, Vertex<String>> vertexes = new HashMap<String, Vertex<String>>();

    /**
     * @param dictionary an initial set of strings
     */
    public RoadCalculator(Set<String> dictionary) {
        if (dictionary == null)
            throw new IllegalArgumentException("dictionary can't be null");
        buildGraph(dictionary);
    }

    private void buildGraph(Set<String> dictionary) {
        Vertex<String> element, nearest;
        String data, nearestData;
        List<String> dataList = new ArrayList<String>(dictionary);
        for (int i = 0, size = dataList.size(); i < size; ++i) {
            data = dataList.get(i);
            element = vertexes.get(data);
            if (element == null)
                element = new Vertex<String>(data);
            for (int j = i + 1; j < size; ++j) {
                nearestData = dataList.get(j);
                if (isNearest(data, nearestData)) {
                    nearest = vertexes.get(nearestData);
                    if (nearest == null)
                        nearest = new Vertex<String>(nearestData);
                    nearest.addNearest(element);
                    vertexes.put(nearestData, nearest);
                    element.addNearest(nearest);
                }
            }
            vertexes.put(data, element);
        }
    }

    private boolean isNearest(String initial, String checking) {
        int size = initial.length();
        if (size != checking.length())
            return false;
        char[] initialChars = initial.toCharArray();
        char[] checkingChars = checking.toCharArray();

        int pos = 0, res = 0;
        int boundedDistance = 2;
        while (pos < size && res < boundedDistance) {
            if (initialChars[pos] != checkingChars[pos])
                ++res;
            ++pos;
        }
        return res < boundedDistance ? true : false;
    }

    /**
     * @param from string to start from
     * @param to   string to find distance to
     * @return List of string between {@code from} and {@code to} strings that differs in each steps no more then on 1 character
     */
    public List<String> calculateRoad(String from, String to) {
        //#1 checking if from and to string are present in graph
        LinkedList<String> results = new LinkedList<String>();
        Vertex<String> fromVertex = vertexes.get(from);
        Vertex<String> toVertex = vertexes.get(to);

        if (fromVertex != null && toVertex != null) {
            //#2 Initiating weight of the from vertex
            Vertex<String> vertex = prepareElements(from);
            //#3 prepare working queue
            List<Vertex<String>> vertexList = new LinkedList<Vertex<String>>();
            vertexList.add(vertex);
            //#4 calculating vertexes weight
            while (!vertexList.isEmpty()) {

                for (Vertex<String> child : vertex.getNearests()) {
                    if (child.getWeight() > vertex.getWeight() + STEP) {
                        child.setWeight(vertex.getWeight() + STEP);
                        vertexList.add(child);
                    }
                }
                vertexList.remove(0);
                if (!vertexList.isEmpty())
                    vertex = vertexList.get(0);
            }

            //#5 finding the smallest distance between from and to
            while (!toVertex.equals(fromVertex)) {
                results.addFirst(toVertex.getValue());
                for (Vertex<String> elem : toVertex.getNearests())
                    if (elem.getWeight() == toVertex.getWeight() - STEP) {
                        toVertex = elem;
                        break;
                    }
            }
            results.addFirst(from);

            //#6 releasing weights for each vertex
            releaseElements();
        }
        return results;
    }

    /**
     * Uses to prepare vertexes to road calculation
     */
    private Vertex<String> prepareElements(String from) {
        vertexes.get(from).setWeight(0);
        return vertexes.get(from);
    }

    /**
     * Uses to release calculation results from vertexes
     */
    private void releaseElements() {
        for (Vertex<String> vertex : vertexes.values()) {
            vertex.setWeight(Integer.MAX_VALUE);
        }
    }
}
