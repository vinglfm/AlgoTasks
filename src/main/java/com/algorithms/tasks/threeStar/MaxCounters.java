package com.algorithms.tasks.threeStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class MaxCounters {
    /**
     * @param maxOperaionVal maximum possible value of elements in ints
     * @param operations     operations that should be provided on output
     * @return array of size maxValue that was updated by operation described {@code in operations}
     * @throws IllegalArgumentException if {@code operations == null} or {@code maxValue <0} or operation in {@code operations} not it [1...maxValue + 1]
     */
    public int[] solution(int maxOperaionVal, int[] operations) {
        if (maxOperaionVal < 1)
            throw new IllegalArgumentException("maxValue should be more then 1");
        if (operations == null)
            throw new IllegalArgumentException("operations shouldn't be null");

        int[] calculatedArray = new int[maxOperaionVal];

        int apdateAllOp = maxOperaionVal + 1;

        int curMax = 0;
        int lastUpdatedMax = 0;
        int curOp;
        int curVal;
        for (int i = 0, size = operations.length; i < size; ++i) {
            curOp = operations[i];
            if (curOp == apdateAllOp) {
                lastUpdatedMax = curMax;
            } else if (curOp > 0 && curOp <= apdateAllOp) {
                curVal = calculatedArray[curOp - 1];
                if (lastUpdatedMax > curVal) {
                    curVal = lastUpdatedMax + 1;
                } else {
                    ++curVal;
                }
                if (curVal > curMax) {
                    curMax = curVal;
                }

                calculatedArray[curOp - 1] = curVal;

            } else {
                throw new IllegalArgumentException("operation should be in range [1..." + apdateAllOp + "]");
            }
        }

        for (int i = 0, size = calculatedArray.length; i < size; ++i) {
            if (calculatedArray[i] < lastUpdatedMax)
                calculatedArray[i] = lastUpdatedMax;
        }

        return calculatedArray;
    }
}
