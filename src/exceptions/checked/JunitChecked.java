package exceptions.checked;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitChecked {

  @Test
  public void testInputString() {
    CheckedMain test = new CheckedMain();
    String actual = test.inputString("Ridvan");

    assertEquals("Ridvan", actual);
  }

  @Test
  public void testIsInputString() {
    CheckedMain test = new CheckedMain();
    String input = test.inputString("Ridvan");

    assertTrue(input.getClass().getSimpleName().contentEquals("String"));
  }

  @Test
  public void testInputInt() {
    CheckedMain test = new CheckedMain();
    int actual = test.inputInteger(5);

    assertEquals(5, actual);
  }

  @Test
  public void testIsInputInt() {
    CheckedMain test = new CheckedMain();
    Integer actual = test.inputInteger(5);

    assertTrue(actual.getClass().getSimpleName().contentEquals("Integer"));
  }

  @Test
  public void testChecked() {
    CheckedMain test = new CheckedMain();
    String verifyChecked = test.testChecked();

    assertTrue("Inputs do not match in type",verifyChecked.length() > 0);
  }

}
