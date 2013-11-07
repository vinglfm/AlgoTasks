package com.algorithms.tasks.oneStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class PermCheck {

    /**
     * @param ints input data for calculation
     * @return 1 if array {@code ints} is permutation, 0 otherwise
     * @throws IllegalArgumentException if {@code ints} is null
     */
    public int solution(int[] ints) {
        if (ints == null)
            throw new IllegalArgumentException("ints can't be null");

        int[] appearence = new int[ints.length];
        int added = 0;
        int currectPos;
        for (int i = 0; i < ints.length; ++i) {
            currectPos = ints[i] - 1;
            if (currectPos < ints.length && currectPos >= 0 && appearence[currectPos] == 0) {
                ++added;
                ++appearence[currectPos];
            } else {
                return 0;
            }
        }
        return added == ints.length ? 1 : 0;
    }
}
