package week14.lab;

import java.io.Serializable;

public class Polygon implements Serializable {
    private static final long serialVersionUID = 1L;
    public int x = 0;
    public int y = 0;
    
    public Polygon(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line extends Polygon {
    private static final long serialVersionUID = 1L;
    public int x2, y2;
    
    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }
}

class Circle extends Polygon {
    private static final long serialVersionUID = 1L;
    public int radius;
    
    public Circle(int x, int y, int r) {
        super(x, y);
        this.radius = r;
    }
}

class Rectangle extends Polygon {
    private static final long serialVersionUID = 1L;
    public int width, height;
    
    public Rectangle(int x, int y, int w, int h) {
        super(x, y);
        this.width = w;
        this.height = h;
    }
}
