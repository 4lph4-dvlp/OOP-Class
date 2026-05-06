public class Propagation {
  public static void main(String[] args) {
    ExceptionScope demo = new ExceptionScope();
    System.out.println("Program beginning.");
    demo.level1();
    System.out.println("Program ending.");
  }
}

class LossOfPrecision extends Exception {
  LossOfPrecision(int num, int denom) {
    super(num + " / " + denom + " loses precision.");
  }
}

class NegativeInputException extends Exception {
  NegativeInputException(int num) {
    super("Negative: " + num);
  }
}
