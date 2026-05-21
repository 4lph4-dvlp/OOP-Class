import java.util.Scanner;
import java.awt.Graphics;

public class Lab8_4_Polygon {
  private int x;
  private int y;
  private static int totalLab8_4_PolygonCount = 0; 

  public Lab8_4_Polygon() {
    totalLab8_4_PolygonCount++;
  }

  public Lab8_4_Polygon(int x, int y) {
    this.x = x;
    this.y = y;
    totalLab8_4_PolygonCount++;
  }

  public int getX() { return x; }
  public int getY() { return y; }
  public void setX(int x) { this.x = x; }
  public void setY(int y) { this.y = y; }
  public static int getTotalLab8_4_PolygonCount() { return totalLab8_4_PolygonCount; }

  protected void disp() { } 

  public void draw(Graphics g) { }
}

class Line extends Lab8_4_Polygon {
  private int x2, y2;

  public Line(int x1, int y1, int x2, int y2) {
    super(x1, y1);
    this.x2 = x2;
    this.y2 = y2;
  }

  public void draw(Graphics g) {
    g.drawLine(getX(), getY(), x2, y2);
  }
}

class Circle extends Lab8_4_Polygon {
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

  public int getRadius() { return radius; }

  protected void disp() {
    System.out.println("Circle " + index + "------------");
    System.out.println("Center point is (" + getX() + "," + getY() + ")");
    System.out.println("Radius is " + radius);
  }

  public void draw(Graphics g) {
    g.drawOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
  }
}

class Rectangle extends Lab8_4_Polygon {
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

  public int getWidth() { return width; }
  public int getHeight() { return height; }

  protected void disp() {
    System.out.println("Rectangle " + index + "------------");
    System.out.println("Left-Top corner point is (" + getX() + "," + getY() + ")");
    System.out.println("Width: " + width);
    System.out.println("Height: " + height);
  }

  public void draw(Graphics g) {
    g.drawRect(getX(), getY(), width, height);
  }
}
