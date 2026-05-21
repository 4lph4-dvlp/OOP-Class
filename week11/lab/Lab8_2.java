import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab8_2 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Position");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new PositionPanel());
    frame.pack();
    frame.setVisible(true);
  }
}

class PositionPanel extends JPanel {
  private Point previous = new Point(0, 0);
  private Point current = null;
  private int count = 0;

  public PositionPanel() {
    setPreferredSize(new Dimension(300, 300));
    setBackground(Color.yellow);
    addMouseListener(new PositionListener());
  }

  public void paintComponent(Graphics page) {
    super.paintComponent(page);

    page.setColor(Color.blue);
    page.setFont(new Font("SansSerif", Font.BOLD, 14));
    page.drawString("count: " + count, 120, 20);

    page.setColor(Color.black);
    page.setFont(new Font("SansSerif", Font.PLAIN, 12));
    if (current != null) {
      page.drawLine(previous.x, previous.y, current.x, current.y);
      page.drawString("(" + previous.x + "," + previous.y + ")", previous.x, previous.y);
      page.drawString("(" + current.x + "," + current.y + ")", current.x, current.y);
    }
  }

  private class PositionListener extends MouseAdapter {
    public void mouseClicked(MouseEvent event) {
      if (current != null) {
        previous = current;
      }
      current = event.getPoint();
      count++;
      repaint();
    }
  }
}
