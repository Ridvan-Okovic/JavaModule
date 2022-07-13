package exceptions;

import exceptions.checked.Checked;
import exceptions.unchecked.Unchecked;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;


public class Main {

    public static void testChecked() {
        int a = 5;
        String b = "Hello";
        System.out.println("Checked exception testing. Before try-catch block.");
        try {
            System.out.println("In try block.");
            String c = a + b;
            throw new Checked("This is a checked exception, can not append integer to String.");
        }
        catch (Checked ex1) {
            System.out.println("In catch block. Exception caught.");
            ex1.printStackTrace();
        }
    }

    public static void testUnchecked() {
        int nums[] = {1, 2, 3, 4, 5};
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nUnchecked exception testing. Before try-catch block");
        try {
            System.out.println("In try block.");
            System.out.println("Enter index of an element you wish to access: ");
            int index = scanner.nextInt();
            if (index >= nums.length) {
                throw new Unchecked("This is an unchecked exception, index out of bounds.");
            }
            else {
                System.out.println(nums[index]);
            }
        }
        catch (Unchecked ex) {
            System.out.println("In catch block. Exception caught.");
            ex.printStackTrace();
        }
    }

    public static void testMultipleExceptions() {
        int nums[] = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter elements of an array");
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = input.nextInt();
            nums[i] = num;
        }

        try {
            System.out.println("Enter index of an element you wish to access: ");
            int index = input.nextInt();
            if (index >= nums.length) {
                throw new ArrayIndexOutOfBoundsException("Can not access that element index is too large");
            }
            else {
                System.out.println("Element at index: " + index + " is " + nums[index]);
            }

            int divide;
            divide = nums[0]/nums[1];
            throw new ArithmeticException("Can not divide a number with 0");
        }
        catch (ArrayIndexOutOfBoundsException | ArithmeticException exception) {
            exception.printStackTrace();
        }
    }



    public static void main(String[] args) {
        testChecked();

        testUnchecked();

        testMultipleExceptions();
    }
}
