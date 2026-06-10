package week11.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MousePolygon {
  public static void main(String[] args) {
    JFrame frame = new JFrame("");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new MainPanel());
    frame.setSize(new Dimension(1000, 1000));
    frame.setVisible(true);
  }
}

class MainPanel extends JPanel {
  public MainPanel() {
    setBackground(Color.black);
    setPreferredSize(new Dimension(1000, 1000));
    setLayout(new BorderLayout());

    JLabel counterLabel = new JLabel("0");
    DrawingPanel drawingPanel = new DrawingPanel();
    JButton clearButton = new JButton("Clear");

    add(counterLabel, BorderLayout.NORTH);
    add(drawingPanel, BorderLayout.CENTER);
    add(clearButton, BorderLayout.SOUTH);

    clearButton.addActionListener(new ClearListener());
  }

  class ClearListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      // clear the drawing panel
    }
  }

  class DrawingPanel extends JPanel {
    public DrawingPanel(Graphics page) {
      setBackground(Color.black);
    }
  }
}