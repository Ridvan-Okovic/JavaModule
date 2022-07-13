package Junit.JunitTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test1 {
    @Test
    public void testAdd() {
        String str = "RickoGricko";
        assertEquals("RickoGricko", str);
    }
}
