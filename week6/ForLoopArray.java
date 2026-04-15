import java.util.Scanner;

public class ForLoopArray {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int age[] = new int[10];
    for (int i = 0; i <10; i ++){
      System.out.print("Enter Student" + (i+1) + "'s age: ");
      age[i] = scan.nextInt();
    }
    System.out.println("The youngest student is " + findYoungest(age) + " years old.");
  }
  private static int findYoungest(int[] age){
    int youngest = age[0];
    for (int i = 1; i < age.length; i++){
      if (age[i] < youngest){
        youngest = age[i];
      }
    }
    return youngest;
  }
}
