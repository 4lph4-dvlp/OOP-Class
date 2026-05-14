import java.util.Scanner;

public class Polygon {
  private int x;
  private int y;
  private static int totalPolygonCount = 0;

  public Polygon() {
    totalPolygonCount++;
  }

  public Polygon(int x, int y) {
    this.x = x;
    this.y = y;
    totalPolygonCount++;
  }

  public int getX() { return x; }
  public int getY() { return y; }
  public void setX(int x) { this.x = x; }
  public void setY(int y) { this.y = y; }
  public static int getTotalPolygonCount() { return totalPolygonCount; }

  protected void disp() { }
}

class Circle extends Polygon {
  private int radius;
  static int count;
  private int index;

  Circle() {
    super();
    Scanner sc = new Scanner(System.in);
    System.out.println("Input x :");
    setX(sc.nextInt());
    System.out.println("Input y :");
    setY(sc.nextInt());
    System.out.println("Input Radius :");
    this.radius = sc.nextInt();

    count++;
    this.index = count;
  }

  Circle(int x, int y, int r) {
    super(x, y);
    this.radius = r;

    count++;
    this.index = count;
  }

  protected void disp() {
    System.out.println("Circle " + index + "------------");
    System.out.println("Center point is (" + getX() + "," + getY() + ")");
    System.out.println("Radius is " + radius);
  }
}

class Rectangle extends Polygon {
  private int width, height;
  private static int count = 0;
  private int index;

  Rectangle() {
    super();
    Scanner sc = new Scanner(System.in);
    System.out.println("Input x :");
    setX(sc.nextInt());
    System.out.println("Input y :");
    setY(sc.nextInt());
    System.out.println("Input width :");
    this.width = sc.nextInt();
    System.out.println("Input height :");
    this.height = sc.nextInt();

    count++;
    this.index = count;
  }

  Rectangle(int x, int y, int w, int h) {
    super(x, y);
    this.width = w;
    this.height = h;

    count++;
    this.index = count;
  }

  protected void disp() {
    System.out.println("Rectangle " + index + "------------");
    System.out.println("Left-Top corner point is (" + getX() + "," + getY() + ")");
    System.out.println("Width: " + width);
    System.out.println("Height: " + height);
  }
}
