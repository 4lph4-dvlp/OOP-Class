import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Lab8_4 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Rubber Lines");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = frame.getContentPane();
    cp.add(new RubberLinePanel());
    frame.pack();
    frame.setVisible(true);
  }
}

class RubberLinePanel extends JPanel {
  ArrayList<Lab8_4_Polygon> plist = new ArrayList<Lab8_4_Polygon>();
  Point p1, p2;
  private JRadioButton b1, b2, b3;
  private boolean clear = false;

  final int CIRCLE = 0;
  final int LINE = 1;
  final int RECTANGLE = 2;
  private int currentType = LINE;

  RubberLinePanel() {
    setPreferredSize(new Dimension(600, 300));

    JPanel buttonPanel = new JPanel();
    makeButonPanel(buttonPanel);
    this.setLayout(new BorderLayout());
    add(buttonPanel, BorderLayout.NORTH);

    add(new DrawPanel(), BorderLayout.CENTER);

    JButton clearButton = new JButton("Clear");
    ClearButtonListener listener = new ClearButtonListener();
    clearButton.addActionListener(listener);
    add(clearButton, BorderLayout.SOUTH);
  }

  void makeButonPanel(JPanel buttonPanel) {
    b1 = new JRadioButton("Circle");
    b2 = new JRadioButton("Line", true);
    b3 = new JRadioButton("Rectangle");

    ButtonGroup group = new ButtonGroup();
    group.add(b1);
    group.add(b2);
    group.add(b3);

    DrawButtonListener listener = new DrawButtonListener();
    b1.addActionListener(listener);
    b2.addActionListener(listener);
    b3.addActionListener(listener);

    buttonPanel.add(b1);
    buttonPanel.add(b2);
    buttonPanel.add(b3);
  }

  private class ClearButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      plist.clear();
      p1 = null;
      p2 = null;
      repaint();
    }
  }

  private class DrawButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == b1) {
        currentType = CIRCLE;
      } else if (event.getSource() == b2) {
        currentType = LINE;
      } else if (event.getSource() == b3) {
        currentType = RECTANGLE;
      }
    }
  }

  private class DrawPanel extends JPanel {
    public DrawPanel() {
      Lab8_4_PolygonListener listener = new Lab8_4_PolygonListener();
      addMouseListener(listener);
      addMouseMotionListener(listener);
      setBackground(Color.black);
      setPreferredSize(new Dimension(600, 250));
    }

    private class Lab8_4_PolygonListener implements MouseListener, MouseMotionListener {
      public void mousePressed(MouseEvent event) {
        p1 = event.getPoint();
        p2 = event.getPoint();
      }

      public void mouseDragged(MouseEvent event) {
        p2 = event.getPoint();
        repaint();
      }

      public void mouseReleased(MouseEvent event) {
        p2 = event.getPoint();
        if (p1 != null && p2 != null) {
          Lab8_4_Polygon poly = null;
          if (currentType == LINE) {
            poly = new Line(p1.x, p1.y, p2.x, p2.y);
          } else if (currentType == CIRCLE) {
            int r = (int) p1.distance(p2);
            poly = new Circle(p1.x, p1.y, r);
          } else if (currentType == RECTANGLE) {
            int x = Math.min(p1.x, p2.x);
            int y = Math.min(p1.y, p2.y);
            int w = Math.abs(p1.x - p2.x);
            int h = Math.abs(p1.y - p2.y);
            poly = new Rectangle(x, y, w, h);
          }
          if (poly != null) {
            plist.add(poly);
          }
        }
        p1 = null;
        p2 = null;
        repaint();
      }

      public void mouseClicked(MouseEvent event) {}
      public void mouseEntered(MouseEvent event) {}
      public void mouseExited(MouseEvent event) {}
      public void mouseMoved(MouseEvent event) {}
    }

    public void paintComponent(Graphics page) {
      super.paintComponent(page);
      page.setColor(Color.yellow);

      for (Lab8_4_Polygon p : plist) {
        p.draw(page);
      }

      if (p1 != null && p2 != null) {
        if (currentType == LINE) {
          page.drawLine(p1.x, p1.y, p2.x, p2.y);
        } else if (currentType == CIRCLE) {
          int r = (int) p1.distance(p2);
          page.drawOval(p1.x - r, p1.y - r, r * 2, r * 2);
        } else if (currentType == RECTANGLE) {
          int x = Math.min(p1.x, p2.x);
          int y = Math.min(p1.y, p2.y);
          int w = Math.abs(p1.x - p2.x);
          int h = Math.abs(p1.y - p2.y);
          page.drawRect(x, y, w, h);
        }
      }
    }
  }
}
