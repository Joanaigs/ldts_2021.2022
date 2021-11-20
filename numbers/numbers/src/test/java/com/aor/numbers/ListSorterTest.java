package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    public List<Integer> helper (){
        return Arrays.asList(1, 2, 4, 2);
    }

    class StudListSorter implements GenericSort{
        @Override
        public List<Integer> sort(List<Integer> list){return Arrays.asList(1,2,2,4);}
    }

    @Test
    public void sort() {
        List<Integer> list = helper();
        List<Integer> expected = Arrays.asList(1, 2,2, 4);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
