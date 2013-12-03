package com.algorithms.basic;

import com.algorithms.tasks.basic.QuickSort;
import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    public Object[] getInputData() {
        return new Object[]{new InputData<>(Arrays.asList(4,5,2,1,3,5,4,3,2,1), Arrays.asList(1,1,2,2,3,3,4,4,
                5,5))};
    }

    @Test
    @Parameters(method = "getInputData")
    public <T extends Comparable<? super T>> void shouldSortArrayOnValidInput(InputData<T> inputData) {
        quickSort.sort(inputData.input);
        TestCase.assertEquals(inputData.expectedResult, inputData.input);
    }


    private static class InputData<T extends Comparable<? super T>> {
        private List<T> input;
        private List<T> expectedResult;

        private InputData(List<T> input, List<T> expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }
    }

}
