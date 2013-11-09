package com.algorithms.tasks.threeStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class GeometricRangeQuery {

    /**
     * @param dna      representation of the dna, could consist only of nucleotides [A,C,G,T]
     * @param begRange begin of the searching range
     * @param endRange end of the searching range
     * @return minimal nucleotides in the searching range
     * @throws IllegalArgumentException if {@code begRange.length != endRange.length}
     */
    public int[] solution(String dna, int[] begRange, int[] endRange) {
        if (dna == null || begRange == null || endRange == null)
            throw new IllegalArgumentException("dna,begRange and endRange mustn't be a null");
        if (begRange.length != endRange.length)
            throw new IllegalArgumentException("begRange and endRange must have the same length");

        int size = begRange.length;
        int[] minNucleotides = new int[size];


        EntranceCalculator calculator = new EntranceCalculator(dna);

        for (int i = 0; i < size; ++i) {
            minNucleotides[i] = calculator.getMinimalDnaCode(begRange[i], endRange[i]);
        }

        return minNucleotides;
    }

    private final static class EntranceCalculator {
        private static final int DNA_CODE_LENGTH = 4;
        private final int[][] entrances;
        private final char[] nucleotides;

        private EntranceCalculator(String dna) {
            nucleotides = dna.toCharArray();
            entrances = new int[DNA_CODE_LENGTH][nucleotides.length];
            calculateEntrances();
        }

        private int[][] calculateEntrances() {
            int aDnaCount = 0, cDnaCount = 0, gDnaCount = 0, tDnaCount = 0;
            for (int i = 0, nucSize = nucleotides.length; i < nucSize; ++i) {

                switch (nucleotides[i]) {
                    case 'A':
                        ++aDnaCount;
                        break;
                    case 'C':
                        ++cDnaCount;
                        break;
                    case 'G':
                        ++gDnaCount;
                        break;
                    case 'T':
                        ++tDnaCount;
                        break;
                    default:
                        throw new IllegalArgumentException("dna element alphabetic presentation should be one of the" +
                                "[A, C, G, T] elements");
                }
                entrances[0][i] = aDnaCount;
                entrances[1][i] = cDnaCount;
                entrances[2][i] = gDnaCount;
                entrances[3][i] = tDnaCount;
            }

            return entrances;
        }

        /**
         * @param beg begin of the range
         * @param end end of the range
         * @return true if validation is successful
         * @throws IllegalArgumentException if {@code beg < 0 || end < 0 || beg > end || beg > nucleotides.length ||
         *                                  end > nucleotides.length}
         */
        private int getMinimalDnaCode(int beg, int end) {
            if (beg < 0 || end < 0 || beg > nucleotides.length || end > nucleotides.length || beg > end) {
                throw new IllegalArgumentException("beg and end have to satisfy next conditions: beg < 0 || end < 0 " +
                        "|| beg > end || beg > nucleotides.length || end > nucleotides.length");
            }
            int diff;
            for (int i = 0; i < DNA_CODE_LENGTH; ++i) {
                if (beg == 0) {
                    diff = entrances[i][end];
                } else if (end > beg) {
                    diff = entrances[i][end] - entrances[i][beg];
                } else {
                    diff = entrances[i][end] - entrances[i][beg - 1];
                }
                if (diff > 0)
                    return i + 1;
            }
            throw new InternalError();
        }

        private static class InternalError extends Error {

            public InternalError() {
                super("EntranceCalculator has an internal error in logic, please contact developers team in " +
                        "order to clarify the problem");
            }
        }
    }
}
