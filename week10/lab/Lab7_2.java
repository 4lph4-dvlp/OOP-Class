import java.awt.*;
import javax.swing.*;

public class Lab7_2 {
  public static void main (String[] args) {
    JFrame frame = new JFrame ("Lab7_2");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new MyPanel());
    frame.pack();
    frame.setVisible(true);
  }
}

class MyPanel extends JPanel { 
  public MyPanel() {
    setPreferredSize (new Dimension(300, 200));
    setBackground (Color.cyan);

    JLabel label = new JLabel("이름: 김현우, 학번: 2023124044");
    label.setForeground(Color.black);
    add(label);
  }

  public void paintComponent(Graphics page) {
    super.paintComponent(page);

    page.setColor(Color.blue);
    page.fillRect(100, 100, 100, 50);
  }
}
