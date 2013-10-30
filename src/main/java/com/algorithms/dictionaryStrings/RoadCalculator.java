package com.algorithms.dictionaryStrings;

import java.util.*;

/**
 * Solves tasks of finding the lowest way from string S1 to Sn-1
 * through nearest strings
 * (where string on each step different from previous one just by 1 character)
 */
public class RoadCalculator {

    private Map<String, Vertex<String>> vertexes = new HashMap<String, Vertex<String>>();

    public RoadCalculator(Set<String> initialData) {
        if (initialData == null)
            throw new IllegalArgumentException("initialData can't be null");
        buildGraph(initialData);
    }

    private void buildGraph(Set<String> dictionary) {
        Vertex<String> element, nearest;
        String data, nearestData;
        List<String> dataList = new ArrayList<String>(dictionary);
        for (int i = 0, size = dataList.size(); i < size; ++i) {
            data = dataList.get(i);
            element = vertexes.get(data);
            if(element == null)
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

    public Collection<String> calculateRoad(String from, String to) {
        //TODO: use vertexes vertexes.values()
        return new ArrayList<String>();
    }
}
