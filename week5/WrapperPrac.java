import java.util.Scanner;

public class WrapperPrac {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("숫자를 입력하세요: ");
    int num = scanner.nextInt();

    String binary = Integer.toBinaryString(num);
    String hex = Integer.toHexString(num);

    System.out.println("2진수: " + binary);
    System.out.println("16진수: " + hex);

    String numStr = Integer.toString(num);

    String remainder = numStr.substring(2);
    System.out.println("나머지 숫자: " + remainder);

    scanner.close();
  }
}
