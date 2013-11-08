package com.algorithms.tasks.twoStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PassingCarsTest {

    private static PassingCars passingCars = new PassingCars();

    public static Object[] getValidInput() {
        return new Object[]{new InputData(new int[]{0, 1, 0, 1, 1}, 5)};
    }

    public static Object[] getInvalidInput() {
        return new Object[]{new InputData(null, 5), new InputData(new int[]{0, 1, 0, -1, 1}, 5)};
    }

    @Test
    @Parameters(method = "getValidInput")
    public void shouldReturnCorrectNumberOfPassingCarsOnValidInput(InputData inputData) {
        TestCase.assertEquals(inputData.expectedResult, passingCars.solution(inputData.passingCars));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInput")
    public void shouldThrowIllegalArgumentExceptionOnInvalidInput(InputData inputData) {
        TestCase.assertEquals(inputData.expectedResult, passingCars.solution(inputData.passingCars));
    }

    private static class InputData {
        private int[] passingCars;
        private int expectedResult;

        private InputData(int[] passingCars, int expectedResult) {
            this.passingCars = passingCars;
            this.expectedResult = expectedResult;
        }
    }
}
