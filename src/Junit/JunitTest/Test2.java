package Junit.JunitTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test2 {
    protected int num1;
    protected int num2;

    public void setUp() {
        num1 = 7;
        num2 = 8;
    }

    @Test
    public void calculator() {
        setUp();
        int result = num1 + num2;
        assertEquals(15, result);
    }
}
