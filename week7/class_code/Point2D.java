public class Point2D implements LengthMeasurable {
    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public double getDistanceFrom(Point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format("Point2D(%.1f, %.1f)", x, y);
    }
}
