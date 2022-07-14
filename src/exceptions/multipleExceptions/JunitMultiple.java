package exceptions.multipleExceptions;

import java.util.Scanner;

public class JunitMultiple {
  public static void testMultipleExceptions() {
    int nums[] = new int[10];
    Scanner input = new Scanner(System.in);
    System.out.println("Before try-catch block");
    System.out.println("Enter elements of an array");
    int num;
    for (int i = 0; i < nums.length; i++) {
      num = input.nextInt();
      nums[i] = num;
    }

    try {
      System.out.println("In try block");
      System.out.println("Enter index of an element you wish to access: ");
      int index = input.nextInt();
      if (index >= nums.length) {
        throw new ArrayIndexOutOfBoundsException("First exception caught, can not access that element index is too large");
      }
      else {
        System.out.println("Element at index: " + index + " is " + nums[index]);
      }

      int divide;
      divide = nums[0]/nums[1];
      throw new ArithmeticException("Second exception caught, can not divide a number with 0");
    }
    catch (ArrayIndexOutOfBoundsException | ArithmeticException exception) {
      System.out.println("In catch block");
      exception.printStackTrace();
    }
  }
}
