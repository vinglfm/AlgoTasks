package com.algorithms.dictionaryStrings;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

@RunWith(JUnitParamsRunner.class)
public class RoadCalculatorTest {
    private RoadCalculator roadCalculator;

    public Object[] getInitialDictionaries() {
        return new Object[][]{{new HashSet<String>(), new HashSet<String>()}, {firstInitialData(), firstResuts()}};
    }

    private Object firstInitialData() {
        Collection<String> initialData = new HashSet<>();
        initialData.add("ving");
        initialData.add("vind");
        initialData.add("bing");
        initialData.add("ring");
        initialData.add("rang");
        initialData.add("viog");
        initialData.add("viod");
        initialData.add("vond");
        initialData.add("rond");
        return initialData;
    }

    private Object firstResuts() {
        Collection<String> result = new HashSet<>();
        result.add("ving");
        result.add("vind");
        result.add("vond");
        result.add("rond");
        return result;
    }

    @Test
    @Parameters(method = "getInitialDictionaries")
    public void shouldCalculateLowestDistance(Set<String> initialData, Set<String> results) {
        roadCalculator = new RoadCalculator(initialData);
        Collection<String> calculatedRoad = roadCalculator.calculateRoad();
        TestCase.assertEquals(calculatedRoad, results);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnInitialDataIsNull() {
        roadCalculator = new RoadCalculator(null);
    }
}
