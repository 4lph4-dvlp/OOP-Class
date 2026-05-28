package week10.class_code;

import java.awt.*;
import javax.swing.*;

public class TrafficLight {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Traffic Light");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().add(new TrafficLightPane());
    frame.pack();
    frame.setVisible(true);
  }
}

/*
 * JPanel을 상속받는 TrafficLightPane을 정의
 */
class TrafficLightPane extends JPanel {
  public TrafficLightPane() {
    this.setPreferredSize(new Dimension(300, 200));
    /*
     * 패널의 크기를 setPreferredSize로 정하는 이유는 메인 함수의 frame에서 pack()이 호출 될 때 일반 setSize로
     * 정하면 해당 크기가 전달 되지 않기 때문이다.
     * 크기를 단순히 x, y로 쓰지 않는 이유는 setPreferredSize가 오직 Dimention 클래스로 정의된 객체만 받기 때문이다.
     */
    this.setBackground(Color.black);
  }

  public void paintComponent(Graphics page) {
    super.paintComponent(page);
    /*
     * super은 TrafficLightPane의 부모 클래스인 JPanel의 메서드를 호출하라는 뜻이다.
     * paintComponent는 JPanel이라는 클래스에 정의된 메서드인데, 이 메서드를TrafficLightPane에서도 사용하기 때문에
     * super을 호출하여 부모 클래스의 메서드를 명시적으로 호출해주는 것이다.
     * JPanel.paintComponent() 메서드는 기본적으로 설정 된 배경색을 이용해 컴포넌트 전체를 칠하는 기능을 한다. 한마디로
     * 화면을 배경색으로 초기화 하는 것이다.
     * 우리는 TrafficLightPane의 생성자에서 setBackground() 메서드를 호출하여 배경색을 설정했으므로,
     * super.paintComponent()가 호출되면 설정 된 배경색을 이용해 컴포넌트 전체를 칠하게 된다.
     */

    /*
     * Graphics 클래스로 정의된 객체들은 JPanel과 같은 객체를 담는 것이 아니다.
     * 그림판의 붓과 같이 생각하면 이해하기 쉽다.
     * 붓의 색을 바꾸고 이를 이용해 채워진 원을 그리는 것이다.
     */
    page.setColor(Color.red);
    page.fillOval(50, 50, 50, 50);

    page.setColor(Color.yellow);
    page.fillOval(100, 50, 50, 50);

    page.setColor(Color.green);
    page.fillOval(150, 50, 50, 50);
  }
}