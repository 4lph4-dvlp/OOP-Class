import java.util.Arrays;

public class coord {
    public static void main(String[] args) {
        // 인터페이스 타입을 배열로 사용하여 다형성 실현
        LengthMeasurable[] pointArr = {
            new Point2D(3, 4),
            new Point3D(1, 2, 2),
            new Point2D(5, 12),
            new Point3D(2, 3, 6)
        };

        System.out.println("점배열 : " + Arrays.toString(pointArr));
        
        for (LengthMeasurable point : pointArr) {
            System.out.printf("점 %s의 원점으로부터의 거리 : %.2f%n", point, point.length());
        }
    }
}
