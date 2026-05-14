import java.util.Scanner;

//원래 2차원 NDice 클래스
class NDice {
  private int faces;
  private int currentFace;

  public NDice(int n) {
    this.faces = n;
    this.currentFace = 1;
  }

  public void roll() {
    this.currentFace = (int) (Math.random() * faces) + 1;
  }

  public int getFace() {
    return currentFace;
  }
}

class KDice extends NDice {
  public KDice(int n) {
    super(n);
  }

  public String toString() {
    return (getFace() == 1) ? "뒷면" : "앞면";
  }
}

public class KoreanDiceGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    KDice yoot1 = new KDice(2);
    KDice yoot2 = new KDice(2);
    KDice yoot3 = new KDice(2);
    KDice yoot4 = new KDice(2);

    System.out.print("윷을 굴리시겠습니까? (Y/N) ");
    String response = scanner.next();

    if (response.equalsIgnoreCase("Y")) {
      yoot1.roll();
      yoot2.roll();
      yoot3.roll();
      yoot4.roll();
      
      System.out.println("윷1 : " + yoot1);
      System.out.println("윷2 : " + yoot2);
      System.out.println("윷3 : " + yoot3);
      System.out.println("윷4 : " + yoot4);
      

      int frontCount = 0;

      if (yoot1.getFace() == 2) frontCount++;
      if (yoot2.getFace() == 2) frontCount++;
      if (yoot3.getFace() == 2) frontCount++;
      if (yoot4.getFace() == 2) frontCount++;

      String result = "";
      switch (frontCount) {
        case 1: result = "도"; break;
        case 2: result = "개"; break;
        case 3: result = "걸"; break;
        case 4: result = "윷"; break;
        case 0: result = "모"; break;
      }
      System.out.println("결과 : " + result);
    }

    scanner.close();
  }
}
