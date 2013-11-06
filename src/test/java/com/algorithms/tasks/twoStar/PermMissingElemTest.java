package com.algorithms.tasks.twoStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
@RunWith(JUnitParamsRunner.class)
public class PermMissingElemTest {

    private static PermMissingElem permMissingElem = new PermMissingElem();

    public static Object[] getCorrectInputData() {
        return new Object[][]{{new InputData(new int[]{2, 3, 1, 5}, 4)}, {new InputData(new int[]{1, 3, 4, 5, 2, 6, 7, 9}, 8)}, {new InputData(new int[]{}, 1)}, {new InputData(new int[]{1}, 2)}};
    }

    @Test
    @Parameters(method = "getCorrectInputData")
    public void shouldCalculateCorrectResultsOnValidInput(InputData inputData) {
        TestCase.assertEquals(inputData.missingValue, permMissingElem.solution(inputData.ints));
    }

    private static class InputData {
        private int[] ints;
        private int missingValue;

        InputData(int[] ints, int missingValue) {
            this.ints = ints;
            this.missingValue = missingValue;
        }
    }
}
