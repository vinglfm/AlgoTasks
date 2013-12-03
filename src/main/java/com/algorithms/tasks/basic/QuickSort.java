package com.algorithms.tasks.basic;

//import StdRandom;

import java.util.List;

public class QuickSort {

    /**
     * @param input
     * @param <T>
     * @return
     */
    public <T extends Comparable<? super T>> void sort(List<T> input) {

        sort(input, 0, input.size() - 1);
    }

    private <T extends Comparable<? super T>> void sort(List<T> input, int lo,
                          int hi) {
        if (lo >= hi) return;
        int partitionElement = partition(input, lo, hi);
        sort(input, lo, partitionElement - 1);
        sort(input, partitionElement + 1, hi);
    }

    private <T extends Comparable<? super T>> int partition(List<T> input, int lo, int hi) {
        int beg = lo, end = hi, index = beg + 1;
        T elem = input.get(lo);
        while (index <= end) {
            int cmp = input.get(index).compareTo(elem);
            if(cmp < 0) {
                T temp = input.get(index);
                input.set(index, input.get(beg));
                input.set(beg, temp);
                ++beg;
                ++index;
            } else if(cmp > 0) {
                T temp = input.get(index);
                input.set(index, input.get(end));
                input.set(end, temp);
                --end;
            } else {
                ++index;
            }
        }
        return beg;
    }
}
