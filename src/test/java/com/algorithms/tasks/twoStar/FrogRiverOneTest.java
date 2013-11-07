package com.algorithms.tasks.twoStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FrogRiverOneTest {

    private static FrogRiverOne frogRiverOne = new FrogRiverOne();

    public static Object[] getValidInputData() {
        return new Object[]{new InputData(new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5, 6), new InputData(new int[]{1}, 1, 0)};
    }

    @Test
    @Parameters(method = "getValidInputData")
    public void shouldCalculateCorrectResultOnValidInput(InputData inputData) {
        TestCase.assertEquals(inputData.answer, frogRiverOne.solution(inputData.destination, inputData.ints));
    }

    public static Object[] getInvalidInputData() {
        return new Object[]{new InputData(null, 1, 1)};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInputData")
    public void shouldThrowIllegalArgumentExceptionOnNullInput(InputData inputData) {
        frogRiverOne.solution(inputData.destination, inputData.ints);
    }

    private static class InputData {
        private int[] ints;
        private int destination;
        private int answer;

        InputData(int[] ints, int destination, int answer) {
            this.ints = ints;
            this.destination = destination;
            this.answer = answer;
        }
    }
}
