package week10.class_code;

import java.awt.*;

public class SmilingFace {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Smiling Face");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SmileFacePane facePanel = new SmileFacePane();
    frame.getContentPane().add(facePanel);
    frame.pack();
    frame.setVisible(true);
  }
}

class SmileFacePane extends JPanel {
  // 전체 그림들의 기본 좌표
  private final int BASE_X = 100, BASE_Y = 100;

  this.setPreferredSize(new Dimension(500,500));this.setBackground(Color.black);
  }

  public void paintComponent(Graphic page) {
    // JPanel의 기본 paintComponent를 이용해 화면 초기화
    super.paintComponent(page);

    // 얼굴
    page.setColor(Color.yellow);
    page.fillOval(BASE_X, BASE_Y, 300, 300);

    page.setColor(Color.black);

    // 눈
    page.fillOval(BASE_X + 50, BASE_Y + 50, 50, 50);
    page.fillOVal(BASE_X +250, BASE_Y + 50, 50, 50);

    //입
    

  }
}