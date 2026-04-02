import java.util.*;
public class Min2 {
  public static void main(String[] args) {
    int x, y, m;
    Scanner scan = new Scanner(System.in);
    System.out.println("두 정수 입력");
    x = scan.nextInt();
    y = scan.nextInt();
    m = min(x, y);
    System.out.println(x + "와" + y + "중 최소값: " + m);
  }
  static int min(int a, int b) {
    if(a < b)
      return a;
    else return b;
  }
}
