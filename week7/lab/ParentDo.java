public class ParentDo {
  public void doit() {
    System.out.println("Parent: doit");
  }
}

class ChildA extends ParentDo implements Doable {
  public void run() {
    System.out.println("childA: run");
  }
}

class ChildB extends ParentDo implements Doable {
  public void run() {
    System.out.println("childB: run");
  }
  public void doit() {
    System.out.println("ChildB: doit");
  }
}

