public class PrintPolygon {
  public static void main(String [] args) {
    Circle c1 = new Circle();
    Circle c2 = new Circle(1, 2, 10);
    Rectangle r1 = new Rectangle();
    Rectangle r2 = new Rectangle(3, 4, 10, 20);

    System.out.println("Total number of polygon:" + Polygon.getTotalPolygonCount());

    Polygon p;

    p = c1;
    p.disp();

    p = c2;
    p.disp();

    p = r1;
    p.disp();

    p = r2;
    p.disp();
  }
}
