package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    public List<Integer> list;
    public List<Integer> expected;

    @BeforeEach
    public void setUp() throws Exception {
        list=Arrays.asList(1,2,4,2);
        expected=Arrays.asList(1,2,2,4);
        ListSorter stubListDuplicator = Mockito.mock(ListSorter.class);
        Mockito.when(stubListDuplicator.sort(list)).thenReturn(expected);
    }

    @Test
    public void sort() {

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
