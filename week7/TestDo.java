public class TestDo {
  public static void main(String[] args) {
    Doable [] dolist = {new ChildA(), new ChildB() };
    ParentDo [] dolist2 = {new ChildA(), new ChildB() };

    ((ParentDo) dolist[0]).doit();
    ((ParentDo) dolist[1]).doit();
    ((Doable) dolist2[0]).run();
    ((Doable) dolist2[1]).run();           
  }
}
