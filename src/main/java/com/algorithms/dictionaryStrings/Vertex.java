package com.algorithms.dictionaryStrings;

import java.util.Collection;
import java.util.HashSet;

/**
 * Represents a single vertex
 * @param <T> type of the data that is presented by the vertex
 */
public class Vertex<T> {
    private T value;
    private Collection<Vertex<T>> nearests = new HashSet<Vertex<T>>();

    /**
     * @param data data that is presented by the vertex
     * @throws IllegalArgumentException if {@code data} is null
     */
    public Vertex(T data) {
        if(data == null)
            throw new IllegalArgumentException("data can't be null");
        this.value = data;
    }

    public Collection<Vertex<T>> getNearests() {
        return nearests;
    }

    /**
     * @param nearest nearest(differs by 1 character) element to the current vertex
     */
    public void addNearest(Vertex<T> nearest) {
        if(nearest == null)
            throw new IllegalArgumentException("nearest vertex can't be null");
        nearests.add(nearest);
    }
}
