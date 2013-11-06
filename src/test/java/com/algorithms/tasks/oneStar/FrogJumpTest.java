package com.algorithms.tasks.oneStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
@RunWith(JUnitParamsRunner.class)
public class FrogJumpTest {

    private static FrogJump frogJump = new FrogJump();

    private static Object[] getValidInputData() {
        return new Object[][]{{10, 85, 30, 3}, {10, 100, 30, 3}, {0, 0, 30, 0}};
    }

    @Test
    @Parameters(method = "getValidInputData")
    public void solutionShouldCalculateCorrectNumberOfJumps(int startPoint, int endPoint, int jumpLength, int expectedJumps) {
        int calculatedJumps = frogJump.solution(startPoint, endPoint, jumpLength);
        TestCase.assertEquals(expectedJumps, calculatedJumps);
    }

    private static Object[] getInvalidInputData() {
        return new Object[][]{{-10, -85, 30, 3}, {10, 100, 0, 3}, {10, 9, 30, 5}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInputData")
    public void solutionShouldThrowIllegalArgumentExceptionOnInvalidData(int startPoint, int endPoint, int jumpLength) {
        frogJump.solution(startPoint, endPoint, jumpLength);
    }
}
