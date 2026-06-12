package week14.lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Lab11_3_client {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Polygon Draw (Lab11_3)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        RubberLinePanel rpanel = new RubberLinePanel();
        frame.getContentPane().add(rpanel);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class RubberLinePanel_Lab11_3 extends JPanel {
    ArrayList<Polygon> plist = new ArrayList<>();
    Point p1, p2;
    
    private JRadioButton b1, b2, b3;
    
    final int CIRCLE = 0;
    final int LINE = 1;
    final int RECTANGLE = 2;
    private int currentType = LINE;
    
    public RubberLinePanel_Lab11_3() {
        setPreferredSize(new Dimension(600, 300));
        
        // Button panel for shape selection
        JPanel buttonPanel = new JPanel();
        makeButtonPanel(buttonPanel);
        this.setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        
        // Draw panel in the center
        add(new DrawPanel(), BorderLayout.CENTER);
        
        // Send and Clear buttons at the bottom
        JPanel southPanel = new JPanel();
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        southPanel.add(sendButton);
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListener());
        southPanel.add(clearButton);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    void makeButtonPanel(JPanel buttonPanel) {
        ButtonGroup buttons = new ButtonGroup();
        b1 = new JRadioButton("Rectangle");
        b2 = new JRadioButton("Oval");
        b3 = new JRadioButton("Line", true); // Default to Line
        
        DrawButtonListener listener = new DrawButtonListener();
        
        buttons.add(b1);
        buttonPanel.add(b1);
        b1.addActionListener(listener);
        
        buttons.add(b2);
        buttonPanel.add(b2);
        b2.addActionListener(listener);
        
        buttons.add(b3);
        buttonPanel.add(b3);
        b3.addActionListener(listener);
    }
    
    private class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try (Socket socket = new Socket("127.0.0.1", 9000);
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                oos.writeObject(plist);
                oos.flush();
                System.out.println("Sent " + plist.size() + " polygons to server.");
            } catch (Exception e) {
                System.err.println("Error sending polygons: " + e.getMessage());
            }
            
            plist.clear();
            p1 = null;
            p2 = null;
            repaint();
        }
    }
    
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("clear !!");
            plist.clear();
            p1 = null;
            p2 = null;
            repaint();
        }
    }
    
    private class DrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JRadioButton b = (JRadioButton) event.getSource();
            String pString = b.getText();
            System.out.println(pString);
            if (pString.equals("Oval")) {
                currentType = CIRCLE;
            } else if (pString.equals("Line")) {
                currentType = LINE;
            } else {
                currentType = RECTANGLE;
            }
            repaint();
        }
    }
    
    private class DrawPanel extends JPanel {
        public DrawPanel() {
            PolygonListener listener = new PolygonListener();
            addMouseListener(listener);
            addMouseMotionListener(listener);
            setBackground(Color.black);
            setPreferredSize(new Dimension(400, 200));
        }
        
        private class PolygonListener implements MouseListener, MouseMotionListener {
            @Override
            public void mousePressed(MouseEvent event) {
                p1 = event.getPoint();
            }
            
            @Override
            public void mouseDragged(MouseEvent event) {
                p2 = event.getPoint();
                repaint();
            }
            
            @Override
            public void mouseReleased(MouseEvent event) {
                Polygon p;
                if (p1 != null && p2 != null) {
                    switch (currentType) {
                        case LINE:
                            p = new Line(p1.x, p1.y, p2.x, p2.y);
                            break;
                        case RECTANGLE:
                            int x = Math.min(p1.x, p2.x);
                            int y = Math.min(p1.y, p2.y);
                            int width = Math.abs(p2.x - p1.x);
                            int height = Math.abs(p2.y - p1.y);
                            p = new Rectangle(x, y, width, height);
                            break;
                        case CIRCLE:
                            int radius = (int) Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
                            p = new Circle(p1.x, p1.y, radius);
                            break;
                        default:
                            return;
                    }
                    plist.add(p);
                    p1 = null;
                    p2 = null;
                    repaint();
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent event) {}
            @Override
            public void mouseEntered(MouseEvent event) {}
            @Override
            public void mouseExited(MouseEvent event) {}
            @Override
            public void mouseMoved(MouseEvent event) {}
        }
        
        @Override
        public void paintComponent(Graphics page) {
            super.paintComponent(page);
            page.setColor(Color.yellow);
            
            // Draw existing polygons
            for (Polygon p : plist) {
                if (p instanceof Circle) {
                    Circle c = (Circle) p;
                    page.drawOval(c.x - c.radius, c.y - c.radius, c.radius * 2, c.radius * 2);
                } else if (p instanceof Rectangle) {
                    Rectangle r = (Rectangle) p;
                    page.drawRect(r.x, r.y, r.width, r.height);
                } else if (p instanceof Line) {
                    Line l = (Line) p;
                    page.drawLine(l.x, l.y, l.x2, l.y2);
                }
            }
            
            // Draw current dragging shape
            if (p1 != null && p2 != null) {
                switch (currentType) {
                    case LINE:
                        page.drawLine(p1.x, p1.y, p2.x, p2.y);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
                        page.drawOval(p1.x - radius, p1.y - radius, radius * 2, radius * 2);
                        break;
                    case RECTANGLE:
                        int x = Math.min(p1.x, p2.x);
                        int y = Math.min(p1.y, p2.y);
                        int width = Math.abs(p2.x - p1.x);
                        int height = Math.abs(p2.y - p1.y);
                        page.drawRect(x, y, width, height);
                        break;
                }
            }
        }
    }
}
