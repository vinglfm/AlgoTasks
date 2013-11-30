package com.algorithms.tasks.threeStar;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MaxPrefixTest {
    private static MaxPrefix maxPrefix = new MaxPrefix();

    public static Object[] getValidInputData() {
        return new Object[]{new InputData("abacabdbaba", 11), new InputData("abababa", 10), new InputData("aabaa", 5),
                new InputData("aaa", 4),
                new InputData("", 0),
                new InputData("a", 1), new InputData("ab", 2), new InputData("aabbbbbb", 8)};
    }

    @Test
    @Parameters(method = "getValidInputData")
    public void shouldReturnMaxProductForPrefix(InputData data) {
        TestCase.assertEquals(data.maxProduct, maxPrefix.solution(data.input));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForNullPrefix() {
        String input = null;
        maxPrefix.solution(input);
    }

    private static class InputData {
        private String input;
        private int maxProduct;

        private InputData(String input, int maxProduct) {
            this.input = input;
            this.maxProduct = maxProduct;
        }
    }
}
