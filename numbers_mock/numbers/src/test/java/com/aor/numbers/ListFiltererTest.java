package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    public List<Integer> expected;
    public ListFilterer stubListFilter;
    /*
    @BeforeEach
    public void setUp() throws Exception {
        list= Arrays.asList(1,2,4,2,-1);
        expected=Arrays.asList(1,2,4,2);
        stubListFilter=new ListFilterer(new PositiveFilter());
        stubListSorter = Mockito.mock(ListSorter.class)
        Mockito.when(stubListFilter.filter(list)).thenReturn(expected);
    }

     */


    @Test
    public void filter1() {
        List<Integer> list= Arrays.asList(1,2,4,2,-1);
        expected=Arrays.asList(1,2,4,2);
        ListFilterer filterre=new ListFilterer(new PositiveFilter());
        Assertions.assertEquals(expected, filterre.filter(list));
    }
    /*
    @BeforeEach
    public void setUp1() throws Exception {
        list= Arrays.asList(1,2,4,2,-1);
        expected=Arrays.asList(2,4,2);
        stubListFilter= new DivisibleFilter(2);
        ListFilterer spy = Mockito.spy(stubListFilter);
        Mockito.when(spy.filter(list)).thenReturn(expected);
    }
    */


    @Test
    public void filter2() throws Exception {
        List<Integer> list= Arrays.asList(1,2,4,2,-1);
        expected=Arrays.asList(2,4,2);
        ListFilterer filterre=new ListFilterer(new DivisibleFilter(2));
        List<Integer> distinct = filterre.filter(list);
        Assertions.assertEquals(expected, distinct);
    }

}
