import java.util.Scanner;

public class MinMAX {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] strArray;
    int i;
    int num;

    System.out.println("How many strings?: ");
    num = sc.nextInt();
    strArray = new String[num];

    System.out.println("Please input " + num + " strings:");
    for (i = 0; i < num; i++) {
      strArray[i] = sc.next();
    }

    System.out.println("before change--------------");
    for (i = 0; i < num; i++) {
      System.out.println(strArray[i]);
    }

    if (args.length > 0) {
      if (args[0].equals("MAX")) {
        findAndReplaceMax(strArray);
      } else if (args[0].equals("MIN")) {
        findAndReplaceMin(strArray);
      }
    }

    System.out.println("after change--------------");
    for (i = 0; i < num; i++) {
      System.out.println(strArray[i]);
    }
  }

  private static void findAndReplaceMax(String[] arr) {
    int maxIdx = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i].length() > arr[maxIdx].length()) {
        maxIdx = i;
      }
    }
    arr[maxIdx] = "MAX";
  }

  private static void findAndReplaceMin(String[] arr) {
    int minIdx = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i].length() < arr[minIdx].length()) {
        minIdx = i;
      }
    }
    arr[minIdx] = "Min";
  }
}
