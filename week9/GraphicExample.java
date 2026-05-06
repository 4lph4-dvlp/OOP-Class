import javax.swing.*;
import java.awt.*;

public class GraphicExample extends JPanel {

    // 화면에 그릴 내용을 정의하는 메서드
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 이전 화면을 지우고 초기화

        // Graphics2D로 캐스팅하면 더 정교한 그래픽 설정이 가능합니다.
        Graphics2D g2d = (Graphics2D) g;

        // 1. 배경색 채우기
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 2. 사각형 그리기 (테두리만)
        g2d.setColor(Color.BLUE);
        g2d.drawRect(50, 50, 100, 100);

        // 3. 채워진 원(타원) 그리기
        g2d.setColor(Color.RED);
        g2d.fillOval(200, 50, 100, 100);

        // 4. 선 그리기
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // 선 두께 조절
        g2d.drawLine(50, 200, 300, 200);

        // 5. 텍스트 출력
        g2d.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        g2d.drawString("Java Graphic Hello!", 70, 250);
    }

    public static void main(String[] args) {
        // 프레임(윈도우창) 생성
        JFrame frame = new JFrame("Java Graphics Basic");
        GraphicExample panel = new GraphicExample();

        frame.add(panel);          // 패널을 프레임에 추가
        frame.setSize(400, 350);   // 창 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 설정
        frame.setLocationRelativeTo(null); // 창을 화면 중앙에 배치
        frame.setVisible(true);    // 창 표시
    }
}