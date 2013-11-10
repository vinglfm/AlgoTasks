package com.algorithms.tasks.oneStar;

import java.util.Arrays;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class MaxProductOfTheThree {
    /**
     * @param ints array to find maximum product value in
     * @return maximum product value
     */
    public int solution(int[] ints) {
        if (ints == null) {
            throw new IllegalArgumentException("ints can't be null");
        }

        Arrays.sort(ints);

        int productValue = ints[ints.length - 1] * ints[ints.length - 2] * ints[ints.length - 3];
        int tempValue = ints[0] * ints[1] * ints[ints.length - 1];

        return productValue > tempValue ? productValue : tempValue;
    }
}
