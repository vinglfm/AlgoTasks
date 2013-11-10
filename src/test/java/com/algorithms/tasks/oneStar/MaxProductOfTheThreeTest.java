package com.algorithms.tasks.oneStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MaxProductOfTheThreeTest {

    private static MaxProductOfTheThree maxProductOfTheThree = new MaxProductOfTheThree();

    public static Object[] getValidData() {
        return new Object[]{new InputData(60, new int[]{-3, 1, 2, -2, 5, 6}), new InputData(20, new int[]{-5, 1, 0,
                -4,
                -2})};
    }

    @Test
    @Parameters(method = "getValidData")
    public void shouldCheckWhetherTriangularExists(InputData data) {
        TestCase.assertEquals(data.expectedResult, maxProductOfTheThree.solution(data.ints));
    }

    public static Object[] getInvalidData() {
        return new Object[]{new InputData(0, null)};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidData")
    public void shouldThrowIllegalArgumentExceptionOnNullInput(InputData data) {
        maxProductOfTheThree.solution(data.ints);
    }

    private static class InputData {
        private int expectedResult;
        private int[] ints;

        private InputData(int expectedResult, int[] ints) {
            this.ints = ints;
            this.expectedResult = expectedResult;
        }
    }
}
