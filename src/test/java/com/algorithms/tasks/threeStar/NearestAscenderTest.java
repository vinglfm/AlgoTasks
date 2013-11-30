package com.algorithms.tasks.threeStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class NearestAscenderTest {

    private NearestAscender nearestAscender = new NearestAscender();

    public static Object[] getValidInputData() {
        return new Object[]{new InputData(new int[0], new int[0]), new InputData(new int[]{4, 3, 1, 4, -1, 2, 1, 5,
                7},
                new int[]{7, 1, 1, 4, 1, 2, 1, 1, 0}), new InputData(new int[]{10, 10, 10, 10, 36, 10, 10, 10, 10},
                new int[]{4, 3, 2, 1, 0, 1, 2, 3, 4}), new InputData(new int[]{1, 2, 3, 4, 50, 5, 6, 7, 8, 9, 10, 9,
                8, 7, 6, 5, 4, 51}, new int[]{1, 1,
                1, 1, 13, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 0})};
    }

    @Test
    @Parameters(method = "getValidInputData")
    public void shouldReturnArrayWithNearestAscender(InputData inputData) {
        int[] result = nearestAscender.solution(inputData.input);
        TestCase.assertTrue("Arrays: {1} - " + Arrays.toString(inputData.expectedResult) + " and {2} - " + Arrays
                .toString(result) + " aren't equals",
                Arrays.equals(inputData.expectedResult, result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnNullInput() {
        int[] input = null;
        nearestAscender.solution(input);
    }

    private static class InputData {
        private int[] input;
        private int[] expectedResult;

        private InputData(int[] input, int[] expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }
    }
}
