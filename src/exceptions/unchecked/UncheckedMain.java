package exceptions.unchecked;

import java.util.Scanner;

public class UncheckedMain {

  public void input(int arr[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter numbers into array: ");
    int size = arr.length;

    for (int i = 0; i<size;i++) {
      int input = scanner.nextInt();
      arr[i] = input;
    }
  }

  public int setIndex(int i) {
    return i;
  }

  public boolean checkIndex(int size, int index) {
    if (index >= size) {
      return true;
    }
    else {
      return false;
    }
  }

  public String printNumber(int[] arr, int index) {
    return ("Your number: " + arr[index]);
  }

  public boolean testUnchecked() {
    int[] nums = {1, 2, 4, 6};

    System.out.println("\nUnchecked exception testing. Before try-catch block");
    try {
      System.out.println("In try block.");
      int index = setIndex(2);
      if (checkIndex(nums.length, index)) {

        throw new Unchecked("This is an unchecked exception, index out of bounds.");
      }
      else {
        System.out.println(printNumber(nums, index));
      }
    }
    catch (Unchecked ex) {
      System.out.println("In catch block. Exception caught.");
      ex.printStackTrace();
      return false;
    }

    return true;

  }

  public static void main(String[] args) {

  }
}
