package week11.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SetBoundsTest {
  public static void main(String[] args) {
    JFrame frame = new JFrame("SetBoundsTest");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    for (int i = 0; i < 5; i++) {
      JButton button = new JButton("Button" + i);
      button.setSize(new Dimension(50, 25));
      button.setBounds(i * 50, i * 50, 100, 50);
      frame.add(button);
    }
    frame.pack();
    frame.setVisible(true);
  }
}
