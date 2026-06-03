package week10.class_code;

import java.awt.*;
import javax.swing.*;

public class NestedPanels {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Nested Panels");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 기반 패널
    JPanel basePanel = new JPanel();
    basePanel.setPreferredSize(new Dimension(150, 100));
    basePanel.setBackground(Color.red);

    // 윗 패널1
    JPanel upperPanel1 = new JPanel();
    upperPanel1.setPreferredSize(new Dimension(50, 30));
    upperPanel1.setBackground(Color.orange);

    // 윗 패널2
    JPanel upperPanel2 = new JPanel();
    upperPanel2.setPreferredSize(new Dimension(50, 30));
    upperPanel2.setBackground(Color.yellow);

    // 각 패널들을 표현할 라벨들
    JLabel label1 = new JLabel("Label 1");
    JLabel label2 = new JLabel("Label 2");
    JLabel baseLabel = new JLabel("Base Label");

    upperPanel1.add(label1);
    upperPanel2.add(label2);
    basePanel.add(baseLabel);
    basePanel.add(upperPanel1);
    basePanel.add(upperPanel2);

    frame.getContentPane().add(basePanel);

    frame.pack();
    frame.setVisible(true);
  }
}
