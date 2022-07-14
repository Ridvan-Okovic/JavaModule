package Junit.tutorialspoint.basicUsage;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestJunit {
  String message = "Hello World";
  MessageUtil messageUtil = new MessageUtil(message);

  @Test
  public void testPrintMessage() {
    message = "New Word";
    assertEquals(message, messageUtil.printMessage());
  }

}
