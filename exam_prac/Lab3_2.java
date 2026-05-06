class KoreanDice extends Dice {
  public KoreanDice(int diceFaces){
    super(diceFaces);
  }
  public String toString() {
    int topFace = getTopFace();
    
    if (topFace ==1) {
      return("뒤면");
    } else {
      return("앞면");
    }
  }
} 

public class Lab3_2 {
  public static void main(String[] args) {
    KoreanDice dice1 = new KoreanDice(2);
    KoreanDice dice2 = new KoreanDice(2);
    KoreanDice dice3 = new KoreanDice(2);
    KoreanDice dice4 = new KoreanDice(2);

    dice1.roll();
    dice2.roll();
    dice3.roll();
    dice4.roll();

    System.out.println("Dice1 : " + dice1);
    System.out.println("Dice2 : " + dice2);
    System.out.println("Dice3 : " + dice3);
    System.out.println("Dice4 : " + dice4);
  }
}
