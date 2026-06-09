package week10.lab.exam_prac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_1 {

  public static void main(String[] args) {
    // 입력 인자 확인
    int num = 3;
    try {
      num = Integer.parseInt(args[0]);
      if (num < 3) {
        num = 3;
      }
    } catch (Exception e) {
      num = 3;
    }

    // 프레임 생성 & 설정
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panelWraper = new JPanel();
    // 버튼 패널 추가
    AnswerPanel answerPanel = new AnswerPanel();
    panelWraper.add(answerPanel);

    // 신호등 패널 추가
    TrafficPanel trafficPanel = new TrafficPanel(num);
    panelWraper.add(trafficPanel);

    frame.add(panelWraper);
    // 프레임 마무리 & 가시화
    frame.pack();
    frame.setVisible(true);
  }
}

class AnswerPanel extends JPanel {
  JButton yes, no;
  JLabel answer;

  public AnswerPanel() {
    // 버튼 패널 기본 설정
    setPreferredSize(new Dimension(400, 200));
    setBackground(Color.yellow);

    // 하위 컴포넌트 생성
    yes = new JButton("Yes");
    no = new JButton("No");
    answer = new JLabel("");

    // 이벤트 리스너 추가
    yes.addActionListener(new buttonListener());
    no.addActionListener(new buttonListener());

    // 컴포넌트 배치
    add(yes);
    add(no);
    add(answer);
  }

  // 이벤트 리스너 정의
  private class buttonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      answer.setText(event.getActionCommand());
    }
  }
}

class TrafficPanel extends JPanel {
  int numCircles;

  public TrafficPanel(int numCircles) {
    this.numCircles = numCircles;
    setPreferredSize(new Dimension(800, 200));
    setBackground(Color.black);
  }

  public void paintComponent(Graphics page) {
    super.paintComponent(page);

    final int RADIUS = 50;
    int remained = numCircles - 3;

    // 빨 노 초 원 출력
    page.setColor(Color.red);
    page.fillOval(10, 75, RADIUS, RADIUS);
    page.setColor(Color.yellow);
    page.fillOval(90, 75, RADIUS, RADIUS);
    page.setColor(Color.green);
    page.fillOval(170, 75, RADIUS, RADIUS);

    // 남은 숫자만큼 파란 원 출력
    page.setColor(Color.blue);
    for (int i = 0; i < remained; i++) {
      page.fillOval(250 + 75 * i, 75, RADIUS, RADIUS);
    }
  }
}