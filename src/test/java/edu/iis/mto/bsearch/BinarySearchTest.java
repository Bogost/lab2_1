package edu.iis.mto.bsearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    int[] oneElement;
    int[] manyElements;

    @Before
    public void setup() {
        int[] oneElementInitializer = {5};
        oneElement = oneElementInitializer;
        int[] manyElementsInitializer = {2, 5, 6, 9, 13};
        manyElements = manyElementsInitializer;
    }

    @Test
    public void elementIsInSequence() {
        SearchResult searchResult = BinarySearch.search(oneElement[0], oneElement);
        assertThat(searchResult.isFound(), Matchers.comparesEqualTo(true));
    }

    @Test
    public void elementIsNotInSequence() {
        SearchResult searchResult = BinarySearch.search(4, oneElement);
        assertEquals(searchResult.isFound(), false);
    }

    @Test
    public void elementIsFirstInSequence() {
        SearchResult searchResult = BinarySearch.search(2, manyElements);
        assertEquals(searchResult.isFound(), true);
        assertEquals(searchResult.getPosition(), 1);
    }

    @Test
    public void elementIsLastInSequence() {
        SearchResult searchResult = BinarySearch.search(13, manyElements);
        assertEquals(searchResult.isFound(), true);
        assertEquals(searchResult.getPosition(), manyElements.length);
    }

    @Test
    public void elementIsInMiddleOfSequence() {
        SearchResult searchResult = BinarySearch.search(6, manyElements);
        // System.out.println(searchResult);
        assertEquals(searchResult.isFound(), true);
        assertEquals(searchResult.getPosition(), 3);
    }

    @Test
    public void elementIsNotInMultiElementalSequence() {
        SearchResult searchResult = BinarySearch.search(8, manyElements);
        assertEquals(searchResult.isFound(), false);
    }
}
