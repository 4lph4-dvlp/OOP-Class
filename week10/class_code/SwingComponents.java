package week10.class_code;

import java.awt.*;
import javax.swing.*;

public class SwingComponents {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Swing Components");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.black);

    // 1행 4열 레이아웃 설정
    frame.getContentPane().setLayout(new GridLayout(1, 4));

    // 각 패널들을 프레임(GridLayout)에 직접 하나씩 추가합니다.
    frame.getContentPane().add(new JCheckBoxPane());
    frame.getContentPane().add(new JRadioButtonPane());
    frame.getContentPane().add(new JComboBoxPane());

    // JListPane 내부에서 스크롤을 처리하도록 하고, 패널을 직접 추가합니다.
    frame.getContentPane().add(new JListPane());

    frame.pack();
    frame.setVisible(true);
  }
}

class JCheckBoxPane extends JPanel {
  public JCheckBoxPane() {
    setOpaque(false); // 검은 배경이 보이도록 투명하게
    JCheckBox joy = new JCheckBox("Joy", true);
    JCheckBox key = new JCheckBox("Key", false);
    JCheckBox mouse = new JCheckBox("Mouse", false);

    // 글자색을 흰색으로 변경 (검은 배경 대비)
    joy.setForeground(Color.white);
    joy.setOpaque(false);
    key.setForeground(Color.white);
    key.setOpaque(false);
    mouse.setForeground(Color.white);
    mouse.setOpaque(false);

    add(joy);
    add(key);
    add(mouse);
  }
}

class JRadioButtonPane extends JPanel {
  public JRadioButtonPane() {
    setOpaque(false);
    ButtonGroup bg = new ButtonGroup();

    JRadioButton red = new JRadioButton("Red", true);
    JRadioButton green = new JRadioButton("Green", false);
    JRadioButton blue = new JRadioButton("Blue", false);

    red.setForeground(Color.white);
    red.setOpaque(false);
    green.setForeground(Color.white);
    green.setOpaque(false);
    blue.setForeground(Color.white);
    blue.setOpaque(false);

    bg.add(red);
    bg.add(green);
    bg.add(blue);

    add(red);
    add(green);
    add(blue);
  }
}

class JComboBoxPane extends JPanel {
  public JComboBoxPane() {
    setOpaque(false);
    JComboBox box = new JComboBox();
    box.addItem("white");
    box.addItem("yellow");
    box.addItem("green");
    box.addItem("blue");

    add(box);
  }
}

class JListPane extends JPanel {
  String items[] = { "apple", "banana", "carot" };

  public JListPane() {
    setOpaque(false);
    JList list = new JList(items);
    list.setVisibleRowCount(3);
    JScrollPane scroll = new JScrollPane(list);
    add(scroll);
  }
}
