package com.algorithms.tasks.threeStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class TapeEquilibrium {
    /**
     * @param ints input data to provide a calculation
     * @return minimum difference between sub arrays
     * @throws IllegalArgumentException if {@code ints == null || ints.length < 2}
     */
    public int solution(int[] ints) {
        if (ints == null || ints.length < 2)
            throw new IllegalArgumentException("ints shouldn't be null or have less then 2 elements");

        int[] sums = new int[ints.length];
        int sum = 0;
        for (int i = 0; i < ints.length; ++i) {
            sum += ints[i];
            sums[i] = sum;
        }
        int lowestDiff = Integer.MAX_VALUE, curDiff;

        for (int i = 0; i < sums.length - 1; ++i) {
            curDiff = Math.abs(sums[sums.length - 1] - 2 * sums[i]);
            if (lowestDiff > curDiff)
                lowestDiff = curDiff;
        }

        return lowestDiff;
    }
}
