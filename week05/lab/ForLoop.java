import java.util.Scanner;

class printLoop {
  public printLoop(int n, String word) {
    for(int i = 0; i < n; i++){
      System.out.println(word);
    }
  }
}

public class ForLoop {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.print("숫자 입력하시오: ");
    int n = scanner.nextInt();
    System.out.print("문자를 입력하시오: ");
    String word = scanner.next();

    new printLoop(n, word);
  }
}
