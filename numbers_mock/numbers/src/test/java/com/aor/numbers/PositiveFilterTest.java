package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void accept()
    {
        PositiveFilter positive=new PositiveFilter();
        Assertions.assertEquals(true, positive.accept(2));
    }
}
