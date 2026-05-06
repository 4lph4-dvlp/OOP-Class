import java.util.Scanner;

public class ExceptionScope {
  public void level1() {
    System.out.println("Level 1 beginning.");
    try {
      level2();
    } catch (LossOfPrecision problem) {
      System.out.println ();
      System.out.println ("The exception message is: " +
          problem.getMessage());
      System.out.println ();
      System.out.println ("The call stack trace:");
      problem.printStackTrace();
      System.out.println ();
    }
    System.out.println("Level 1 ending.");
  }
  public void level2() throws LossOfPrecision {
    System.out.println("Level 2 beginning.");
    try {level3 ();}
    catch (NegativeInputException problem) {
      System.out.println(problem);
    }
    System.out.println("Level 2 ending.");
  }
  public void level3 () throws LossOfPrecision, NegativeInputException {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int denom = sc.nextInt();
    if (num < 0)
      throw new NegativeInputException(num);
    else if (denom < 0)
      throw new NegativeInputException(denom);
    if (num %denom!=0) 
      throw new LossOfPrecision(num,denom);
    int result = num /denom;
  }
}
