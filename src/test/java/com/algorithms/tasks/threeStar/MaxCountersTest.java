package com.algorithms.tasks.threeStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class MaxCountersTest {

    private static final MaxCounters maxCounters = new MaxCounters();

    public static Object[] getValidInput() {
        return new Object[]{new InputData(new int[]{3, 4, 4, 6, 1, 4, 4}, 5, new int[]{3, 2, 2, 4, 2}),
                new InputData(new int[]{3, 4, 4, 6, 1, 4, 4}, 7, new int[]{1, 0, 1, 4, 0, 1, 0}),
                new InputData(new int[]{11, 11, 11, 11, 11, 11, 11}, 10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0})};
    }

    @Test
    @Parameters(method = "getValidInput")
    public static void shouldUpdateAnEmptyArrayAccordingToSpecifiedOperations(InputData inputData) {
        TestCase.assertTrue(Arrays.equals(inputData.expectedResult, maxCounters.solution(inputData.maxValue,
                inputData.operations)));
    }

    public static Object[] getInvalidInput() {
        return new Object[]{new InputData(new int[]{-3, 4, 4, 6, 1, 4, 4}, 5, new int[]{3, 2, 2, 4, 2}),
                new InputData(null, 5, new int[]{3, 2, 2, 4, 2}), new InputData(new int[]{-3, 4, 4, 6, 1, 4, 4}, -1,
                new int[]{3, 2, 2, 4, 2})};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInput")
    public static void shouldThrowIllegalArgumentExceptionOnIncorrectInput(InputData inputData) {
        TestCase.assertTrue(Arrays.equals(inputData.expectedResult, maxCounters.solution(inputData.maxValue,
                inputData.operations)));
    }

    private static class InputData {
        private int[] operations;
        private int maxValue;
        private int[] expectedResult;

        InputData(int[] operations, int maxValue, int[] resultValues) {
            this.operations = operations;
            this.maxValue = maxValue;
            this.expectedResult = resultValues;
        }
    }
}
