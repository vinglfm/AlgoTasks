package com.algorithms.tasks.oneStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PermCheckTest {

    private static PermCheck permCheck = new PermCheck();

    public static Object[] getValidInputData() {
        return new Object[]{new InputData(new int[]{4, 1, 3, 2}, 1), new InputData(new int[]{1}, 1), new InputData(new int[]{1, 2}, 1), new InputData(new int[]{1, 3}, 0), new InputData(new int[]{}, 1)};
    }

    @Test
    @Parameters(method = "getValidInputData")
    public void shouldCalculateCorrectResultOnValidInput(InputData inputData) {
        TestCase.assertEquals(inputData.answer, permCheck.solution(inputData.ints));
    }

    public static Object[] getInvalidInputData() {
        return new Object[]{new InputData(null, 0)};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInputData")
    public void shouldThrowIllegalArgumentExceptionOnInvalidInput(InputData inputData) {
        TestCase.assertEquals(inputData.answer, permCheck.solution(inputData.ints));
    }

    private static class InputData {
        private int[] ints;
        private int answer;

        InputData(int[] ints, int answer) {
            this.ints = ints;
            this.answer = answer;
        }
    }
}
