package com.algorithms.tasks.twoStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class PermMissingElem {
    /**
     * @param inputArr input data to provide a calculation
     * @return missing element in the array
     */
    public int solution(int[] inputArr) {
        long arraySum = 0;
        for (int i = 0; i < inputArr.length; ++i)
            arraySum += inputArr[i];

        long n = inputArr.length + 1;
        long lengthSum = n * (n + 1) / 2;

        return (int) (lengthSum - arraySum);
    }
}
