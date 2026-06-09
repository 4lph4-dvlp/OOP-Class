package week10.class_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Mile {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mile<->Kilo Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ConverterPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

class ConverterPanel extends JPanel {
    private JTextField mile, kilo;
    private JButton convert;

    public ConverterPanel() {
        // 거대한 창보다는 적당한 크기가 보기 좋아서 500x200으로 조절했습니다.
        setPreferredSize(new Dimension(500, 200));
        setLayout(new GridLayout(3, 1, 5, 5)); // 마지막 두 인자는 위아래 간격(Gap)입니다.

        mile = new JTextField("Put Mile value here");
        kilo = new JTextField("Put Kilometer value here");
        convert = new JButton("Convert");

        mile.addActionListener(new TextFieldListener());
        kilo.addActionListener(new TextFieldListener());
        convert.addActionListener(new ButtonListener());

        add(mile);
        add(kilo);
        add(convert);
    }

    // 엔터키를 쳤을 때 작동하는 리스너 (기존 코드 유지)
    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double mileValue, kiloValue;
            DecimalFormat fmt = new DecimalFormat("0.##");
            try {
                if (event.getSource() == mile) {
                    String text = mile.getText();
                    mileValue = Double.parseDouble(text);
                    kiloValue = mileValue * 1.609344;
                    kilo.setText(fmt.format(kiloValue));
                } else if (event.getSource() == kilo) {
                    String text = kilo.getText();
                    kiloValue = Double.parseDouble(text);
                    mileValue = kiloValue / 1.609344;
                    mile.setText(fmt.format(mileValue));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "숫자만 입력해주세요!");
            }
        }
    }

    // [Convert] 버튼을 눌렀을 때 작동하는 리스너 (오타 수정 및 로직 개선)
    private class ButtonListener implements ActionListener { // 1. 오타 수정
        public void actionPerformed(ActionEvent event) {
            double mileValue, kiloValue;
            DecimalFormat fmt = new DecimalFormat("0.##");

            String mileText = mile.getText();
            String kiloText = kilo.getText();

            // 2. 어느 쪽에 숫자가 입력되었는지 판별하여 양방향 변환 가능하게 처리
            try {
                // 이전에 우리가 작성한 텍스트 리스너와 원리는 같습니다.
                // mile창에 숫자가 있으면 mile -> kilo 변환
                if (isNumeric(mileText)) {
                    mileValue = Double.parseDouble(mileText);
                    kiloValue = mileValue * 1.609344;
                    kilo.setText(fmt.format(kiloValue));
                } 
                // kilo창에만 숫자가 있으면 kilo -> mile 변환
                else if (isNumeric(kiloText)) {
                    kiloValue = Double.parseDouble(kiloText);
                    mileValue = kiloValue / 1.609344;
                    mile.setText(fmt.format(mileValue));
                } else {
                    JOptionPane.showMessageDialog(null, "변환할 숫자를 입력해주세요!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "올바른 숫자가 아닙니다.");
            }
        }

        // 텍스트가 올바른 숫자 형식인지 체크해주는 도우미 메서드
        private boolean isNumeric(String str) {
            if (str == null) return false;
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}