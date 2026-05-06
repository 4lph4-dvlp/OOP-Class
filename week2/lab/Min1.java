import java.util.*;

public class Min1 {
  public static void main(String[] args){
    int x, y;
    Scanner scan = new Scanner(System.in);
    System.out.println("두 정수 입력");
    x = scan.nextInt();
    y = scan.nextInt();
    if(x < y){
      System.out.println("최소값은 " + x);
    } else {
      System.out.println("최소값은 " + y);
    }
  }}
