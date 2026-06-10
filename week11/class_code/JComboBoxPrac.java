package week11.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JComboBoxPrac {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JComboBox Practice");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MainPanel mainPanel = new MainPanel();
    frame.getContentPane().add(mainPanel);
    frame.pack();
    frame.setVisible(true);
  }
}

class MainPanel extends JPanel {
  private JComboBox<String> combo;
  private ArrayList<String> subjects = new ArrayList<>();
  private JTextField answerText;

  public MainPanel() {
    setLayout(new GridLayout(1, 2));
    setBackground(Color.yellow);

    subjects.add("수학");
    subjects.add("화학");
    subjects.add("생명과학");
    subjects.add("컴퓨터공학");

    combo = new JComboBox<>();
    JPanel answerPanel = new JPanel();
    combo.setPreferredSize(new Dimension(100, 50));
    add(combo);
    add(answerPanel);

    answerPanel.setLayout(new GridLayout(1, 2));
    answerPanel.add(new JLabel("나의 전공"));
    answerText = new JTextField();
    answerText.setPreferredSize(new Dimension(100, 50));
    answerPanel.add(answerText);

    for (int i = 0; i < 4; i++) {
      combo.addItem(subjects.get(i));
      combo.addItemListener(new ComboListener());
    }
  }

  class ComboListener implements ItemListener {
    public void itemStateChanged(ItemEvent event) {
      if (event.getStateChange() == ItemEvent.SELECTED) {
        answerText.setText(combo.getSelectedItem().toString());
      }
    }
  }
}