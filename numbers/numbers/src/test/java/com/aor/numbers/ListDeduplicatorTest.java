package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    public List<Integer> helper (){
        return Arrays.asList(1,2,4,2);
    }

    class StudListDeduplicator implements GenericListDeduplicator{
        @Override
        public List<Integer> deduplicate(List<Integer> list) {return Arrays.asList(1,2,4);}
    }

    @Test
    public void deduplicate() {
        List<Integer> list = helper();
        List<Integer> expected = Arrays.asList(1,2,4);

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
}
