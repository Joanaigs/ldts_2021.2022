package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleFilterTest {
    @Test
    public void accept()
    {
        DivisibleFilter divisable=new DivisibleFilter(2);
        Assertions.assertEquals(true, divisable.accept(2));
    }
}
