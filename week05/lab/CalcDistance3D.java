import java.util.Scanner;

//원래 2차원 Point 클래스
class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() { return x; }
  public int getY() { return y; }

  @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }

  //호출하라고 한 distanceFrom 코드
  public double distanceFrom(Point p) {
    double dist = Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    return dist;
  }
}

class Point3D extends Point {
  private int z;

  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  public int getZ() { return z; }
    public String toString() {
      return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

  public double distanceFrom(Point3D p) {
    double dist2D = super.distanceFrom(p);

    return Math.sqrt(Math.pow(dist2D, 2) + Math.pow(this.z - p.getZ(), 2));
  }
}

public class CalcDistance3D {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Point3D p = readPoint(scan, "첫 번째 점의 좌표 x, y, z 를 입력하세요.");
    Point3D q = readPoint(scan, "두 번째 점의 좌표 x, y, z 를 입력하세요.");

    System.out.printf("%s과(와) %s 사이의 거리 = %5.2f%n",
        p.toString(), q.toString(), p.distanceFrom(q));
  }

  private static Point3D readPoint(Scanner scan, String prompt) {
    System.out.print(prompt + " ");
    int x = scan.nextInt();
    int y = scan.nextInt();
    int z = scan.nextInt();
    Point3D p = new Point3D(x, y, z);
    return p;
  }
}
