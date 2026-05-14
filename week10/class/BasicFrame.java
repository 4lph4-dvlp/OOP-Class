import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

public class BasicFrame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Basic GUI Frame");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.YELLOW);

    Container contentPane = frame.getContentPane();
    contentPane.add(panel);
    frame.setVisible(true);

  }
}
