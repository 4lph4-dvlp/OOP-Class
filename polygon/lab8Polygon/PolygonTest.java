package polygon.lab8Polygon;

import java.awt.Container;
import javax.swing.JFrame;

public class PolygonTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rubber Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = frame.getContentPane();
        cp.add(new RubberLinePanel());
        frame.pack();
        frame.setVisible(true);
    }
}
