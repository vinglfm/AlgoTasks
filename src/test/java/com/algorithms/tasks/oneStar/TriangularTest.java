package com.algorithms.tasks.oneStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TriangularTest {

    private static Triangular triangular = new Triangular();

    public static Object[] getValidData() {
        return new Object[]{new InputData(0, new int[]{10, 50, 5, 1}), new InputData(1, new int[]{10, 2, 5, 1, 8,
                20})};
    }

    @Test
    @Parameters(method = "getValidData")
    public void shouldCheckWhetherTriangularExists(InputData data) {
        TestCase.assertEquals(data.expectedResult, triangular.solution(data.ints));
    }

    public static Object[] getInvalidData() {
        return new Object[]{new InputData(0, null)};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidData")
    public void shouldThrowIllegalArgumentExceptionOnNullInput(InputData data) {
        triangular.solution(data.ints);
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
