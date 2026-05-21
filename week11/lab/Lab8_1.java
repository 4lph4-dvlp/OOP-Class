import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab8_1 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Year");
    YearPanel panel = new YearPanel();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}

class YearPanel extends JPanel {
  private JRadioButton[] radioButton;
  private JLabel prevLabel = new JLabel("나의 이전 학년");
  private JTextField prevTextField = new JTextField(10);
  private JLabel currLabel = new JLabel("나의 현재 학년");
  private JTextField currTextField = new JTextField(10);
  private String[] yearText = {"1학년", "2학년", "3학년", "4학년"};

  public YearPanel() {
    setLayout(new GridLayout(0, 1)); 
    setBackground(Color.yellow);

    YearListener listener = new YearListener();

    JPanel radioRow = new JPanel();
    radioRow.setBackground(Color.yellow);

    ButtonGroup buttons = new ButtonGroup();
    radioButton = new JRadioButton[yearText.length];
    for (int i = 0; i < radioButton.length; i++) {
      radioButton[i] = new JRadioButton(yearText[i]);
      radioButton[i].setBackground(Color.yellow);
      buttons.add(radioButton[i]);
      radioRow.add(radioButton[i]);
      radioButton[i].addItemListener(listener);
    }
    add(radioRow);

    JPanel prevRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
    prevRow.setBackground(Color.yellow);
    prevRow.add(prevLabel);
    prevRow.add(prevTextField);
    add(prevRow);

    JPanel currRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
    currRow.setBackground(Color.yellow);
    currRow.add(currLabel);
    currRow.add(currTextField);
    add(currRow);

    JPanel dummyRow1 = new JPanel();
    dummyRow1.setBackground(Color.yellow);
    add(dummyRow1);

    JPanel dummyRow2 = new JPanel();
    dummyRow2.setBackground(Color.yellow);
    add(dummyRow2);

    setPreferredSize(new Dimension(320, 240));
  }

  private class YearListener implements ItemListener {
    public void itemStateChanged(ItemEvent event) {
      JRadioButton source = (JRadioButton) event.getSource();

      if (event.getStateChange() == ItemEvent.DESELECTED) {
        prevTextField.setText(source.getText());
      }
      else if (event.getStateChange() == ItemEvent.SELECTED) {
        currTextField.setText(source.getText());
      }
    }
  }
}
