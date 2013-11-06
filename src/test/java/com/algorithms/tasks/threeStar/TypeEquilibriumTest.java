package com.algorithms.tasks.threeStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TypeEquilibriumTest {
    private static TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

    public static Object[] getCorrectInputData() {
        return new Object[]{new InputData(new int[]{2, 3, 1, 5}, 1), new InputData(new int[]{1, 3, 4, 5, 2, 6, 7, 9}, 5), new InputData(new int[]{1, 1}, 0), new InputData(new int[]{-1, 1}, 2)};
    }

    @Test
    @Parameters(method = "getCorrectInputData")
    public void shouldCalculateCorrectResultsOnValidInput(InputData inputData) {
        TestCase.assertEquals(inputData.lowestDiff, tapeEquilibrium.solution(inputData.ints));
    }

    private static Object[] getInvalidInputData() {
        return new Object[]{new InputData(null, 1), new InputData(new int[]{1}, 1)};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInputData")
    public void solutionShouldThrowIllegalArgumentExceptionOnInvalidData(InputData inputData) {
        tapeEquilibrium.solution(inputData.ints);
    }


    private static class InputData {
        private int[] ints;
        private int lowestDiff;

        InputData(int[] ints, int lowestDiff) {
            this.ints = ints;
            this.lowestDiff = lowestDiff;
        }
    }
}
