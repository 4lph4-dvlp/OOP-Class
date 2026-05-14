import java.util.Scanner;

public class Add {
  public static void main(String[] args) {
    int x, y;
    Scanner scan = new Scanner(System.in);

    System.out.println("X? ");
    x = scan.nextInt();

    System.out.println("Y? ");
    y = scan.nextInt();

    System.out.println(x + " + " + y + " = " + (x + y));
    System.out.println("Name: Hyunwoo Kim");
    System.out.println("ID: 2023124044");
  }
}
