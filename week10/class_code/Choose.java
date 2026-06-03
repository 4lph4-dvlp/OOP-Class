package week10.class_code;

import java.awt.*;
import javax.swing.*;

public class Choose {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Choose");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    JPanel buttonWrapper = new JPanel();

    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");

    buttonWrapper.add(yes);
    buttonWrapper.add(no);
    buttonWrapper.setOpaque(false);

    JLabel label = new JLabel("Choose Yes or No");
    /*
     * panel을 따로 둔는 이유 : 그냥 buttonWrapper와 label모두를 단순 frame의 ContentPane에 직접적으로 넣으면
     * 컴포넌트들이 겹치기 때문이다.
     */
    panel.setBackground(Color.yellow);
    panel.add(buttonWrapper);
    panel.add(label);

    frame.getContentPane().add(panel);

    frame.pack();
    frame.setVisible(true);
  }
}