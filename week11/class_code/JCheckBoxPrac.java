package week11.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JCheckBoxPrac {

  public static void main(String[] args) {
    // 프레임 생성
    JFrame frame = new JFrame("JCheckBox Practice");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MainPanel mainPanel = new MainPanel();
    frame.getContentPane().add(mainPanel);
    frame.pack();
    frame.setVisible(true);
  }

}

class MainPanel extends JPanel {
  private JTextField answerText;

  // 교과 항목 ArrayList로 저장
  ArrayList<String> subjects = new ArrayList<String>();

  ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

  public MainPanel() {
    setLayout(new GridLayout(2, 1));
    setBackground(Color.yellow);

    subjects.add("수학");
    subjects.add("화학");
    subjects.add("생명과학");
    subjects.add("컴퓨터공학");

    // 패널 구성
    JPanel buttonWrapper = new JPanel();
    JPanel answerWrapper = new JPanel();
    buttonWrapper.setLayout(new GridLayout(1, 4));
    buttonWrapper.setOpaque(false);
    answerWrapper.setLayout(new GridLayout(1, 2));
    answerWrapper.setOpaque(false);

    add(buttonWrapper);
    add(answerWrapper);

    // 과목 별 체크박스 버튼 생성 및 이벤트 등록
    for (int i = 0; i < 4; i++) {
      checkBoxList.add(new JCheckBox(subjects.get(i)));
      buttonWrapper.add(checkBoxList.get(i));
      checkBoxList.get(i).addActionListener(new checkedListener());
      checkBoxList.get(i).setOpaque(false);
    }

    // 답 부분 컴포넌트 구성
    answerWrapper.add(new JLabel("나의 전공"));
    answerText = new JTextField();
    answerWrapper.add(answerText);
    answerText.setSize(new Dimension(100, 10));
  }

  class checkedListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String str = "";
      for (int i = 0; i < checkBoxList.size(); i++) {
        if (checkBoxList.get(i).isSelected()) {
          str += checkBoxList.get(i).getText() + ", ";
        }
      }
      answerText.setText(str);
    }
  }
}