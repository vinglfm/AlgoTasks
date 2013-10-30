package com.algorithms.dictionaryStrings;

import java.util.Collection;

/**
 * Contains a basic logic for all tests
 */
public class BaseTest {

    protected <T> boolean contains(Collection<T> elems, T elem) {
        for(T singleElem : elems) {
            if(singleElem.equals(elem))
                return true;
        }
        return false;
    }

}
