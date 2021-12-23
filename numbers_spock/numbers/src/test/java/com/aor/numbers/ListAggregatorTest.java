package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    public List<Integer> list;
    public List<Integer> expected;
    private GenericSort sorter;
    ListDeduplicator stubListDuplicator;

    @BeforeEach
    public void setUp() throws Exception {
        list=Arrays.asList(1,2,4,2);
        expected=Arrays.asList(1,2,4);
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        stubListDuplicator = Mockito.mock(ListDeduplicator.class);
        Mockito.when(stubListDuplicator.deduplicate(list)).thenReturn(expected);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(9, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);
    }

    @Test
    public void max_bug_7263(){
        List<Integer> list = Arrays.asList(-1, -4, -5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        int distinct = aggregator.distinct(list, stubListDuplicator);
        Assertions.assertEquals(3, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2),
                deduplicator);
        Assertions.assertEquals(3, distinct);
    }
}
