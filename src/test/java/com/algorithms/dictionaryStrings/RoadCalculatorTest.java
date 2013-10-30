package com.algorithms.dictionaryStrings;

import com.algorithms.dictionaryStrings.exceptions.IncorrectInputException;
import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RunWith(JUnitParamsRunner.class)
public class RoadCalculatorTest {
    private RoadCalculator roadCalculator;

    public Object[] getInitialDictionaries() throws FileNotFoundException {

        String fileName = "src/test/resources/ten.txt";
        String delimiter = " ";

        return new Object[]{readInitialData(fileName, delimiter)};
    }

    private RoadCalculatorDataHolder readInitialData(String fileName, String delimiter) throws FileNotFoundException {
        RoadCalculatorDataHolder roadCalculatorDataHolder = new RoadCalculatorDataHolder(fileName, delimiter);
        return roadCalculatorDataHolder;
    }

    @Test
    @Parameters(method = "getInitialDictionaries")
    public void shouldCalculateLowestDistance(RoadCalculatorDataHolder data) {
        roadCalculator = new RoadCalculator(data.inputData);
        Collection<String> calculatedRoad = roadCalculator.calculateRoad(data.from, data.to);
        TestCase.assertEquals(calculatedRoad, data.outputData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnInitialDataIsNull() {
        roadCalculator = new RoadCalculator(null);
    }

    /**
     * Represents an initial data for a test case.
     * Data should be in the next order:
     * <br/>#1 input_data
     * <br/>#2 word_to_start word_to_find
     * <br/>#3 output_data
     */
    private static final class RoadCalculatorDataHolder {
        private Set<String> inputData = new HashSet<String>();
        private Set<String> outputData = new HashSet<String>();
        private String from;
        private String to;

        /**
         * @param fileName  name of the file to load data from
         * @param delimiter delimiter for the single data element
         * @throws IncorrectInputException if data is presented isn't in the proper way(specified in comments to class)
         * @throws FileNotFoundException if file wasn't found
         */
        private RoadCalculatorDataHolder(String fileName, String delimiter) throws FileNotFoundException {
            initialize(fileName, delimiter);
        }

        private void initialize(String fileName, String delimiter) throws FileNotFoundException {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(fileName));

                String[] line = br.readLine().split(delimiter);

                for (String data : line) {
                    inputData.add(data);
                }

                line = br.readLine().split(delimiter);
                from = line[0];
                to = line[1];

                line = br.readLine().split(delimiter);
                for (String data : line) {
                    outputData.add(data);
                }
            } catch (FileNotFoundException exp) {
                throw exp;
            } catch (IOException exp) {
                throw new IncorrectInputException("File can't be found or input from " + fileName + " isn't in correct order", exp);
            } finally {
                if (br != null)
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

    }
}
