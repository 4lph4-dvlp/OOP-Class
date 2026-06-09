package week11.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderLayoutTest {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Border Layout Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout());

    frame.add(new JButton("North"), BorderLayout.NORTH);
    frame.add(new JButton("South"), BorderLayout.SOUTH);
    frame.add(new JButton("East"), BorderLayout.EAST);
    frame.add(new JButton("West"), BorderLayout.WEST);
    frame.add(new JButton("Center"), BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}