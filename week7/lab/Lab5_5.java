abstract class HauMember1 {
  public abstract void greet();
  public abstract void work();

  public void introduce() {
    System.out.println("Hi everybody");
    greet();
    work();
  }
}

class HauStudent1 extends HauMember1 {
  public void greet() {
    System.out.println("How are you?");
  }
  public void work() {
    System.out.println("I am studying.");
  }
}

class HauTeacher1 extends HauMember1 {
  public void greet() { 
    System.out.println("Hello"); 
  }
  public void work() { 
    System.out.println("I am teaching");
  }
}

public class Lab5_5 {
  public static void main(String[] args) {
    HauMember1[] p = new HauMember1[3];
    p[0] = new HauStudent1();
    p[1] = new HauTeacher1();

    p[0].introduce();
    System.out.println("-------------------------");
    p[1].introduce();
  }
}
