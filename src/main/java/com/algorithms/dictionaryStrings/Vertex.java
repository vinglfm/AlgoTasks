package com.algorithms.dictionaryStrings;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Represents a single vertex
 *
 * @param <T> type of the data that is presented by the vertex
 */
class Vertex<T> implements Comparable<Vertex<T>> {
    private T value;
    private int weight = Integer.MAX_VALUE;
    private Collection<Vertex<T>> nearests = new HashSet<Vertex<T>>();

    /**
     * @param data data that is presented by the vertex
     * @throws IllegalArgumentException if {@code data} is null
     */
    Vertex(T data) {
        if (data == null)
            throw new IllegalArgumentException("data can't be null");
        this.value = data;
    }

    /**
     * @return all nearest vertexes for this vertex
     */
    Collection<Vertex<T>> getNearests() {
        return Collections.unmodifiableCollection(nearests);
    }

    /**
     * @param nearest nearest(differs by 1 character) element to the current vertex
     */
    void addNearest(Vertex<T> nearest) {
        if (nearest == null)
            throw new IllegalArgumentException("nearest vertex can't be null");
        nearests.add(nearest);
    }

    /**
     * @return weight of the vertex
     */
    int getWeight() {
        return weight;
    }

    /**
     * @param weight new weight of the vertex
     */
    void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return value of the vertex
     */
    T getValue() {
        return value;
    }

    @Override
    public int compareTo(Vertex<T> elem) {
        return weight < elem.weight ? 1 : (weight == elem.weight ? 0 : -1);
    }
}
