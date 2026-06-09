package week11.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutTest {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Grid Layout Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new GridLayout(2, 3));

    for (int i = 0; i < 5; i++) {
      frame.add(new JButton("Button" + i));
    }
    frame.pack();
    frame.setVisible(true);
  }
}
