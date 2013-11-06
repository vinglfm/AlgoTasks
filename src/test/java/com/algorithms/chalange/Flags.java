package com.algorithms.chalange;

public class Flags {

    public static void main(String[] args) {
        int[] mountains = new int[]{1};//1,5,3,4,3,4,1,2,3,4,6,2 - 3    //7, 10, 4, 5, 7, 4, 6, 1, 4, 3, 3, 7 - 3
        //4, 5, 8, 5, 1, 4, 6, 8, 7, 2, 2, 5 - 2
        System.out.println(new Flags().solution(mountains));
    }

    public int solution(int[] array) {
        return calculateFlagsNumber(getPeeks(array));
    }

    private int[] getPeeks(int[] array) {
        if (array.length < 2)
            return new int[]{};

        int[] temp = new int[array.length / 2 + 1];
        int pos = 0;

        for (int i = 1; i < array.length - 1; ++i) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                temp[pos++] = i;
                ++i;
            }
        }

        int[] peeks = new int[pos];
        System.arraycopy(temp, 0, peeks, 0, peeks.length);
        return peeks;
    }

    private int calculateFlagsNumber(int[] peeks) {
        if (peeks.length < 1)
            return 0;

        int correctFlags = 0;
        int beg = 0, last = peeks.length;
        int tempFlags, diff;

        int flags = (last + beg) / 2;

        while (last >= beg) {
            diff = (last - beg) / 2;
            if (diff == 0)
                diff = 1;

            if (validate(peeks, flags)) {
                correctFlags = flags;
                beg += diff;
            } else {
                last -= diff;
            }
            tempFlags = (last + beg) / 2 + 1;
            if (correctFlags >= tempFlags)
                break;
            flags = tempFlags;
        }
        return correctFlags;
    }

    private boolean validate(int[] peeks, int flags) {
        int curFlags = flags - 1;
        int pos = 1;
        int gap = 0;
        while (curFlags > 0 && (pos + gap) < peeks.length && ((peeks.length - pos) - curFlags) >= 0) {
            if (peeks[pos + gap] - peeks[pos - 1] >= flags) {
                --curFlags;
                pos += gap + 1;
                gap = 0;
            } else {
                ++gap;
            }
        }

        return curFlags == 0;
    }

}
