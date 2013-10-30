package com.algorithms.dictionaryStrings;

import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class VertexTest extends BaseTest {

    Vertex<String> vertex;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionElementIsNull() {
        vertex = new Vertex<String>(null);
    }

    @Test
    public void shouldCreateNearestVertexesOnCreation() {
        String acceptedElement = "element";
        vertex = new Vertex<String>(acceptedElement);

        TestCase.assertNotNull(vertex.getNearests());
    }

    public Object[] getElemsToAdd() {
        return new Object[] {"Hey", "Box"};
    }

    @Test
    @Parameters(method = "getElemsToAdd")
    public void shouldAddVertexToNearestVertexes(String elem) {
        vertex = new Vertex<String>(elem);
        Vertex<String> nearest = new Vertex<String>(elem);
        vertex.addNearest(nearest);

        TestCase.assertTrue(contains(vertex.getNearests(), nearest));
    }

}
