package exceptions.unchecked;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitUnchecked {

  @Test
  public void testSetIndex() {
    UncheckedMain test = new UncheckedMain();
    int actual = test.setIndex(5);

    assertEquals(5, actual);
  }

  @Test
  public void testPrintNumber() {
    UncheckedMain test = new UncheckedMain();
    int index = 3;
    int[] arr = {1, 2, 3, 4};

    String actual = test.printNumber(arr, index);

    assertEquals("Your number: 4", actual);
  }

  @Test
  public void testInvalidCheckIndex() {
    UncheckedMain test = new UncheckedMain();
    boolean verifyTest = test.checkIndex(3, 5);

    assertTrue("Index can not be larger than size.",verifyTest);
  }

  @Test
  public void testValidCheckIndex() {
    UncheckedMain test = new UncheckedMain();
    boolean verifyTest = test.checkIndex(5, 3);

    assertTrue(verifyTest);
  }

  @Test
  public void testUnchecked() {
    UncheckedMain test = new UncheckedMain();
    boolean result = test.testUnchecked();

    assertTrue("Index out of bounds.", result);
  }


}
