import javax.swing.*;
import java.awt.*;

public class HelloFrame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello Frame"); // title바 제목
    Container contentPane = frame.getContentPane(); // 텍스트를 넣을 공간 생성
    JLabel label = new JLabel("Hello, Swing!"); // 텍스트 넣을 공간에 텍스트 정의
    contentPane.add(label); // 텍스트 넣을 공간에 텍스트 넣기
    frame.pack(); // 화면 크기 조절
    frame.setVisible(true); // 화면에 보이기
  }
}
