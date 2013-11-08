package com.algorithms.tasks.twoStar;

/**
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class PassingCars {
    private static final int MAX_PASSING_CARS = 1000000000;

    /**
     * @param passingCars represents cars on the motorway: <p/> 0 - moving east, 1 - moving west
     * @return number of the passing cars
     * @throws IllegalArgumentException if {@code passingCars == null} or passingCars contains illegal direction
     *                                  presentation not in [0...1]
     */
    public int solution(int[] passingCars) {
        if (passingCars == null) {
            throw new IllegalArgumentException("passingCars can't be null");
        }

        int countedCars = 0;
        for (int i = 0, size = passingCars.length; i < size; ++i) {
            countedCars += passingCars[i];
        }

        int passedCars = 0;
        int sumPassedCars = 0;
        for (int i = 0, size = passingCars.length - 1; i < size; ++i) {
            switch (passingCars[i]) {
                case 0:
                    sumPassedCars += countedCars - passedCars;
                    if (sumPassedCars > MAX_PASSING_CARS)
                        return -1;
                    break;
                case 1:
                    passedCars += passingCars[i];
                    break;
                default:
                    throw new IllegalArgumentException("element in passingCars should be in [0...1]");
            }
        }

        return sumPassedCars;
    }
}
