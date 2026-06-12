package polygon.lab8Polygon;

import java.util.*;

public class Polygon {
    int x = 0;
    int y = 0;
    private static int count = 0;

    public Polygon() {
        Scanner scan = new Scanner(System.in);
        System.out.println("input x :");
        x = scan.nextInt();
        System.out.println("input y :");
        y = scan.nextInt();
        count++;
    }

    public Polygon(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
    }

    public void disp() {
        ;
    }

    public String getX() {
        String strX = x + "";
        return strX;
    }

    public String getY() {
        String strX = y + "";
        return strX;
    }

    public int getCount() {
        return count;
    }
}

class Line extends Polygon {
    int x2, y2; // End point

    Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }
}

class Circle extends Polygon {
    int radius;
    static int count_cir = 1;
    private int index;

    public Circle() {
        super();
        Scanner scan = new Scanner(System.in);
        System.out.println("input Radius :");
        radius = scan.nextInt();
        index = count_cir++;
    }

    Circle(int x, int y, int r) {
        super(x, y);
        this.radius = r;
        index = count_cir++;
        super.x = x;
    }

    public void disp() {
        System.out.println("Circle " + index + "------------" + "\n" + "\t"
                + "Center point is " + "(" + getX() + "," + getY() + ")" + "\n" + "\t"
                + "Radius is " + radius + "\n");
    }

    public String toString() {
        String rst = "Circle " + index + "------------" + "\n" + "\t"
                + "Center point is " + "(" + getX() + "," + getY() + ")" + "\n" + "\t"
                + "Radius is " + radius + "\n";
        return rst;
    }
}

class Rectangle extends Polygon {
    int width, height;
    private static int count_rec = 1;
    private int index;

    Rectangle(int x, int y, int w, int h) {
        super(x, y);
        index = count_rec++;
        this.width = w;
        this.height = h;
    }

    Rectangle() {
        super();
        Scanner scan = new Scanner(System.in);
        System.out.println("input width :");
        width = scan.nextInt();
        System.out.println("input height :");
        height = scan.nextInt();
        index = count_rec++;
    }

    public void disp() {
        System.out.println("Rectangle " + index + "------------" + "\n" + "\t"
                + "Left-TOP corner point is " + "(" + super.getX() + "," + super.getY() + ")" + "\n" + "\t"
                + "Width: " + width + "\n" + "\t"
                + "Height: " + height + "\n");
    }
}
