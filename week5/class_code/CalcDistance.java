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

public class CalcDistance {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Point p1 = getPoint(scan, "p1");
    Point p2 = getPoint(scan, "p2");
    System.out.println(p1.toString() + "와 " + p2.toString() + "의 거리는 " + getDistance(p1, p2) + "입니다.");
    scan.close();
  }

  private static Point getPoint(Scanner scan, String pointName) {
    System.out.print(pointName + "의 좌표를 입력하시오. ex: 3 1 >>> ");
    double x = scan.nextDouble();
    double y = scan.nextDouble();
    
    Point pointBuf = new Point(x, y);
    
    return pointBuf;
  }

  private static double getDistance(Point p1, Point p2) {
    double distance = Math.abs(Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2)));
    return distance;
  }
}
