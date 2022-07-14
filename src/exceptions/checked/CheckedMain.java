package exceptions.checked;

public class CheckedMain {
  public String inputString(String input) {
    return input;
  }

  public int inputInteger(int input) {
    return input;
  }

  public String testChecked() {
    String a = inputString("Ridvan");
    Integer b = inputInteger(5);
    String c = "";

    System.out.println("Checked exception testing. Before try-catch block.");
    try {
      System.out.println("In try block.");
      if (a.getClass().getSimpleName().contentEquals("String") &&
              b.getClass().getSimpleName().contentEquals("String")) {
        c = a + b;
        System.out.println("Output: " + c);
      }
      else {
        throw new Checked("This is a checked exception, can not append integer to String.");
      }
    }
    catch (Checked ex1) {
      String catchMessage = "In catch block. Exception caught.";
      System.out.println(catchMessage);
      ex1.printStackTrace();
    }
    return c;
  }

  public static void main(String[] args) {
    CheckedMain test = new CheckedMain();
    test.testChecked();
  }
}
