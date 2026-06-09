package week10.class_code;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Dots {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Dots");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new DotsPanel);
    
    frame.pack();
    frame.setVisible(true);
  }
}

public class DotsPanel extends JPanel {
  private final int RADIUS = 6; // 점 반지름

  private ArrayList<Point> pointLit;

}