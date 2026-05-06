import java.util.*;

class Dice {
  private int diceFaces;
  private int topFace;
  
  public Dice(int diceFaces) {
    this.diceFaces = diceFaces;
  }
  public int getTopFace() {
    return topFace;
  }
  public int getDiceFaces() {
    return diceFaces;
  }

  public int roll() {
    topFace = (int)(Math.random() * (diceFaces)) + 1;
    return topFace;
  }

}

public class Lab2_2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("주사의 면의 갯수를 입력하세요 >>>");
    int diceFaces = scan.nextInt();
    Dice dice1 = new Dice(diceFaces);
    Dice dice2 = new Dice(diceFaces);
    
    System.out.print("주사위 두개 모두 굴릴까요? (y/n) >>>");
    String yn = scan.next().toLowerCase();
    if(yn.equals("y")) {
      dice1.roll();
      dice2.roll();

      System.out.println("주사위1 : " + dice1.getTopFace());
      System.out.println("주사위2 : " + dice2.getTopFace());
      System.out.println("주사위합 : " + (dice1.getTopFace() + dice2.getTopFace()));
    }
    scan.close();
  }
}

