package com.algorithms.tasks.oneStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class FrogJump {

    /**
     * @param startPoint point to start from
     * @param endPoint destination point
     * @param jumpLength length of a single jump
     * @return number of jumps to rich a destination point
     */
    int solution(int startPoint, int endPoint, int jumpLength) {
        if (startPoint < 0 || endPoint < 0 || jumpLength <= 0)
            throw new IllegalArgumentException("startPoint, endPoint couldn't be negative and jumpLength couldn't be 0 or negative");
        if (startPoint > endPoint)
            throw new IllegalArgumentException("startPoint should be less or equal to endPoint");

        int distance = endPoint - startPoint;
        return distance / jumpLength + (distance % jumpLength != 0 ? 1 : 0);
    }
}
