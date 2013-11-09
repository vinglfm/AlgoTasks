package com.algorithms.tasks.threeStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class GeometricRangeQueryTest {

    private static final GeometricRangeQuery geomQuery = new GeometricRangeQuery();

    public static Object[] getValidInput() {
        return new Object[]{new InputData("GACACCATA", new int[]{0, 0, 4, 7}, new int[]{8, 2, 5, 7}, new int[]{1, 1,
                2, 4}), new InputData("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1}, new int[]{1, 1, 2}),
                new InputData("GATT", new int[]{0, 1, 2, 3}, new int[]{1, 1, 3, 3}, new int[]{1, 1, 4, 4})};
    }

    public static Object[] getInvalidInput() {
        return new Object[]{new InputData(null, new int[]{0, 0, 4, 7}, new int[]{8, 2, 5, 7}, new int[]{1, 1, 2, 4}),
                new InputData("GACACCATA", null, new int[]{8, 2, 5, 7}, new int[]{1, 1, 2, 4}),
                new InputData("GACACCATA", new int[]{0, 0, 4, 7}, null, new int[]{1, 1, 2, 4}),
                new InputData("GACACCATA", new int[]{9, 0, 4, 7}, new int[]{8, 2, 5, 7}, new int[]{1, 1, 2, 4})};
    }

    @Test
    @Parameters(method = "getValidInput")
    public void shouldFindMinimalNucletidesInSpecifiedRange(InputData data) {
        TestCase.assertTrue("Results isn't equals", Arrays.equals(geomQuery.solution(data.dna, data.begRange,
                data.endRange), data.expectedResults));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInput")
    public void shouldThrowIllegalArgumentExceptionOnInvalidInput(InputData data) {
        geomQuery.solution(data.dna, data.begRange, data.endRange);
    }

    private static class InputData {
        private String dna;
        private int[] begRange;
        private int[] endRange;
        private int[] expectedResults;

        private InputData(String dna, int[] begRange, int[] endRange, int[] expectedResults) {
            this.dna = dna;
            this.begRange = begRange;
            this.endRange = endRange;
            this.expectedResults = expectedResults;
        }
    }
}
