package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    public List<Integer> list;
    public List<Integer> expected;
    private ListSorter sorter;
    ListSorter stubListSorter;


    @BeforeEach
    public void setUp() throws Exception {
        list=Arrays.asList(1,2,4,2);
        expected=Arrays.asList(1,2,4);
        stubListSorter = Mockito.mock(ListSorter.class);
        Mockito.when(stubListSorter.sort(list)).thenReturn(expected);
    }

    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator(stubListSorter);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }
}
