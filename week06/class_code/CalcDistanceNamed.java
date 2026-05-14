import java.util.*;

class Point {
  private double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }

  public String toString() {
    String buf = "(" + x + ", " + y + ")";
    return buf;
  }
}

class NamedPoint extends Point {
  private String name;
  public NamedPoint(String name, double x, double y) {
    super(x, y);
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public String toString() {
    String buf = name + super.toString();
    return buf;
  }
}

public class CalcDistanceNamed {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    NamedPoint p1 = getPoint(scan, "p1");
    NamedPoint p2 = getPoint(scan, "p2");
    System.out.println(p1.toString() + "와 " + p2.toString() + "의 거리는 " + getDistance(p1, p2) + "입니다.");
    scan.close();
  }

  private static NamedPoint getPoint(Scanner scan, String pointName) {
    System.out.print(pointName + "의 좌표 이름과 값을 입력하시오. ex: pointA 3 1 >>> ");
    String name = scan.next();
    double x = scan.nextDouble();
    double y = scan.nextDouble();

    NamedPoint pointBuf = new NamedPoint(name, x, y);

    return pointBuf;
  }

  private static double getDistance(NamedPoint p1, NamedPoint p2) {
    double distance = Math.abs(Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2)));
    return distance;
  }
}
