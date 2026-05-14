package kr.ac.kau.OOP2025;

class KoreanStudent implements Studiable {
    public void greetings() {
      System.out.println("무엇을 도와드릴까요 ?");
    }

  public void work() {
    System.out.println("--------------------");
    for (int i = 0; i < 3; i++) {
      greetings();
    }
    System.out.println("--------------------");
  }
}

class AmericanStudent implements Studiable {
  public void greetings() {
    System.out.println("May I help you?");
  }

  public void work() {
    System.out.println("--------------------");
    for (int i = 0; i < 3; i++) {
      greetings();
    }
    System.out.println("--------------------");
  }
}

public class Lab5_4 {
  public static void main(String[] args) {
    Studiable[] p = new Studiable[2];
    p[0] = new KoreanStudent();
    p[1] = new AmericanStudent();

    for (int i = 0; i < p.length; i++) {
      p[i].work();
    }
  }
}
