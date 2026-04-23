class Student {
  public void greetings() {
    System.out.println(" ... ");
  }

  public void work() {
    System.out.println("--------------------");
    for (int i = 0; i < 3; i++) {
      greetings();
    }
    System.out.println("--------------------");
  }
}

class KoreanStudent extends Student {
  public void greetings() {
    System.out.println("무엇을 도와드릴까요 ?");
  }
}

class AmericanStudent extends Student {
  public void greetings() {
    System.out.println("May I help you?");
  }
}

public class Lab5_2 {
  public static void main(String[] args) {
    Student[] p = new Student[2];
    p[0] = new KoreanStudent();
    p[1] = new AmericanStudent();

    for (int i = 0; i < p.length; i++) {
      p[i].work();
    }
  }
}
