package week10.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChooseAnswer {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Choose & Answer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ChooseAnswerPanel());
    frame.pack();
    frame.setVisible(true);
  }
}

class ChooseAnswerPanel extends JPanel {
  private JLabel answer;
  private JButton yes;
  private JButton no;

  public ChooseAnswerPanel() {
    setPreferredSize(new Dimension(500, 500));
    setLayout(new GridLayout(2, 1));

    yes = new JButton("YES");
    no = new JButton("NO");
    yes.addActionListener(new ButtonListener());
    no.addActionListener(new ButtonListener());
    add(yes);
    add(no);

    answer = new JLabel("Your Answer is : ");
    add(answer);
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      answer.setText(event.getActionCommand());
    }
  }
}