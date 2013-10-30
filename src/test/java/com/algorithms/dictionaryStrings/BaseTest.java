package com.algorithms.dictionaryStrings;

import java.util.Collection;
import java.util.Iterator;

/**
 * Contains a basic logic for all tests
 */
public class BaseTest {
    /**
     * checking if collections are equals
     *
     * @param first  collection to check for equality
     * @param second collection to check for equality
     * @param <T>    type of the element in the collection
     * @return true if collections are equal, false otherwise
     * @throws IllegalArgumentException if {@code first == null || second == null}
     */
    protected <T> boolean equals(Collection<T> first, Collection<T> second) {
        if(first == null || second == null)
            throw new IllegalArgumentException("Comparing collections can't be null");

        if (first.size() != second.size())
            return false;

        Iterator<T> secondIter = second.iterator();
        for (T elem : first) {
            if (!elem.equals(secondIter.next()))
                return false;
        }
        return true;
    }

}
