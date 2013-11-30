package com.algorithms.tasks.threeStar;

import java.util.LinkedList;
import java.util.List;

public class NearestAscender {

    /**
     * @param input array to find ascenders for
     * @return array of distances to nearest ascenders
     */
    public int[] solution(int[] input) {
        if(input == null) {
            throw new IllegalArgumentException("input array can't be a null");
        }
        int[] distances = new int[input.length];
        if (distances.length < 1) {
            return distances;
        }

        acsendingUpdate(input, distances);
        descendingUpdate(input, distances);

        return distances;
    }

    private void acsendingUpdate(int[] input, int[] distances) {
        LinkedList<Integer> previousElems = new LinkedList<Integer>();
        previousElems.add(input[0]);
        int max = input[0];
        List<Integer> maxIndexes = new LinkedList<Integer>();
        maxIndexes.add(0);

        int diff = 1;
        int currentValue;
        for(int i = 1, size = input.length; i < size; ++i) {
            currentValue = input[i];

            if(currentValue > max) {

                for (int index : maxIndexes) {
                    distances[index] = i - index;
                }
                max = currentValue;
                maxIndexes.clear();
                maxIndexes.add(i);

                previousElems.clear();
                previousElems.addFirst(currentValue);

            } else if (currentValue < max) {
                for(int prevValue : previousElems) {
                    if(prevValue > currentValue) {
                        distances[i] = diff;
                        break;
                    }
                    ++diff;
                }
                previousElems.addFirst(currentValue);
                diff = 1;
            } else {
                maxIndexes.add(i);
                previousElems.addFirst(currentValue);
            }
        }
    }

    private void descendingUpdate(int[] input, int[] distances) {
        LinkedList<Integer> previousElems = new LinkedList<Integer>();
        int lastElem = input[input.length - 1];
        previousElems.add(lastElem);
        int max = lastElem;
        List<Integer> maxIndexes = new LinkedList<Integer>();
        maxIndexes.add(input.length - 1);

        int diff = 1;
        int currentValue;
        for(int i = input.length - 2; i >= 0; --i) {
            currentValue = input[i];

            if(currentValue > max) {

                for (int index : maxIndexes) {
                    distances[index] = Math.min(distances[index], Math.abs(i - index));
                }
                max = currentValue;
                maxIndexes.clear();
                maxIndexes.add(i);

                previousElems.clear();
                previousElems.addFirst(currentValue);

            } else if (currentValue < max) {
                for(int prevValue : previousElems) {
                    if(prevValue > currentValue) {
                        distances[i] = Math.min(distances[i], diff);
                        break;
                    }
                    ++diff;
                }
                previousElems.addFirst(currentValue);
                diff = 1;
            } else {
                maxIndexes.add(i);
                previousElems.addFirst(currentValue);
            }
        }
    }
}
