package com.algorithms.tasks.twoStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class FrogRiverOne {
    /**
     * @param destination destination point in travel
     * @param ints        leaf positions
     * @return which time a little frog would spend passing a river, -1 - if it is not possible
     * @throws IllegalArgumentException if {@code ints} is null or {@code destination < 1}
     */
    public int solution(int destination, int[] ints) {
        if (ints == null)
            throw new IllegalArgumentException("ints can't be null");
        if (destination < 1)
            throw new IllegalArgumentException("destination should be more then 0");

        int check = destination;
        int[] road = new int[destination];
        int leafPos;
        for (int i = 0; i < ints.length; ++i) {
            leafPos = ints[i] - 1;
            if (leafPos >= 0 && leafPos < ints.length) {
                if (road[leafPos] == 0) {
                    ++road[leafPos];
                    --check;
                }
                if (check == 0)
                    return i;
            } else {
                return -1;
            }
        }

        return -1;
    }
}
