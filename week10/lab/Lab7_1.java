import java.awt.*;
import javax.swing.*;

public class Lab7_1{
  public static void main(String[] args) {
    int numCircles = 3;

    if (args.length > 0) {
      numCircles = Integer.parseInt(args[0]);
      if (numCircles < 3) {
        numCircles = 3;
      }
    }

    JFrame frame = new JFrame("Lab7_1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout()); 

    JPanel answer = new JPanel();
    answer.setBackground(Color.yellow);
    answer.setPreferredSize(new Dimension(250, 75));

    JButton yes = new JButton("YES");
    JButton no = new JButton("NO");
    JLabel label = new JLabel("Choose YES or NO");

    answer.add(yes);
    answer.add(no);
    answer.add(label);

    TrafficLightPanel traffic = new TrafficLightPanel(numCircles);

    frame.getContentPane().add(answer, BorderLayout.NORTH);
    frame.getContentPane().add(traffic, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}

class TrafficLightPanel extends JPanel {
  private int numCircles;

  public TrafficLightPanel(int numCircles) {
    this.numCircles = numCircles;
    setPreferredSize(new Dimension(50 * numCircles + 50, 200));
    setBackground(Color.black);
  }

  public void paintComponent(Graphics page) {
    super.paintComponent(page);

    int x = 50;

    for (int i = 0; i < numCircles; i++) {
      if (i == 0) {
        page.setColor(Color.red);
      } else if (i == 1) {
        page.setColor(Color.yellow);
      } else if (i == 2) {
        page.setColor(Color.green);
      } else {
        page.setColor(Color.blue);
      }

      page.fillOval(x, 50, 40, 40);
      x += 50;
    }
  }
}
