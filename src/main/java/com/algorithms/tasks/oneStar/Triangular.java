package com.algorithms.tasks.oneStar;

import java.util.Arrays;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class Triangular {

    /**
     * @param ints array to find triangular in
     * @return 1 if triangular exists, 0 otherwise
     * @throws IllegalArgumentException if {@code ints == null}
     */
    public int solution(int[] ints) {

        if (ints == null) {
            throw new IllegalArgumentException("ints can't be null");
        }

        Arrays.sort(ints);

        for (int i = 1; i < ints.length - 1; ++i) {
            if (ints[i] + ints[i - 1] > ints[i + 1])
                return 1;
        }

        return 0;
    }
}
