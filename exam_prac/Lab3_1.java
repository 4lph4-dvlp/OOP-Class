import java.util.*;

public class Lab3_1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("3자리 이상 수를 입력하시오 >>> ");
    Integer num = scan.nextInt();
    if(((int) num / 1000) < 1) {System.out.println("입력된 숫자는 3자리 이상 수가 아닙니다.");}
    else {
      System.out.println(Integer.toBinaryString(num));
      System.out.println(Integer.toHexString(num));
      System.out.println((num.toString()).substring(2));
    } 
    scan.close();
  }
}

