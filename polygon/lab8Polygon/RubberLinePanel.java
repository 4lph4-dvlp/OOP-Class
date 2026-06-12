package polygon.lab8Polygon;

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
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RubberLinePanel extends JPanel {
    ArrayList<Polygon> plist = new ArrayList<Polygon>();
    Point p1, p2;

    private JRadioButton b1, b2, b3;
    private boolean clear = false;

    final int CIRCLE = 0;
    final int LINE = 1;
    final int RECTANGLE = 2;
    private int currentType = LINE;

    public RubberLinePanel() {
        setPreferredSize(new Dimension(600, 300));

        // add button panel on BorderLayout.north
        JPanel buttonPanel = new JPanel();
        makeButonPanel(buttonPanel);
        this.setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);

        // add draw panel
        add(new DrawPanel(), BorderLayout.CENTER);

        // add clear button
        JButton clearButton = new JButton("Clear");
        ClearButtonListener listener = new ClearButtonListener();
        clearButton.addActionListener(listener);
        add(clearButton, BorderLayout.SOUTH);
    }

    void makeButonPanel(JPanel buttonPanel) {
        ButtonGroup buttons = new ButtonGroup();
        b1 = new JRadioButton("Circle");
        b2 = new JRadioButton("Line");
        b3 = new JRadioButton("Rectangle");

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

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            clear = true;
            System.out.println("clear !!");
            plist.clear();
            p1 = null;
            p2 = null;
            repaint();
        }
    }

    private class DrawButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JRadioButton b = (JRadioButton) event.getSource();
            String pString = b.getText();
            System.out.println(pString);
            if (pString.equals("Circle") == true) {
                currentType = CIRCLE;
            } else if (pString.equals("Line") == true) {
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
            public void mousePressed(MouseEvent event) {
                p1 = event.getPoint();
            }

            public void mouseDragged(MouseEvent event) {
                p2 = event.getPoint();
                repaint();
            }

            public void mouseClicked(MouseEvent event) {
            }

            public void mouseReleased(MouseEvent event) {
                Polygon p;
                if (p1 != null && p2 != null) {
                    switch (currentType) {
                        case LINE:
                            p = new Line(p1.x, p1.y, p2.x, p2.y);
                            break;
                        case RECTANGLE:
                            int width = Math.abs(p2.x - p1.x);
                            int height = Math.abs(p2.y - p1.y);
                            // Draw rectangle relative to top-left corner
                            int rx = Math.min(p1.x, p2.x);
                            int ry = Math.min(p1.y, p2.y);
                            p = new Rectangle(rx, ry, width, height);
                            break;
                        case CIRCLE:
                            int radius = (int) Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
                            p = new Circle(p1.x, p1.y, radius);
                            break;
                        default:
                            return;
                    }

                    plist.add(p);

                    // reset p1 and p2
                    p1 = null;
                    p2 = null;
                    repaint();
                }
            }

            public void mouseEntered(MouseEvent event) {
            }

            public void mouseExited(MouseEvent event) {
            }

            public void mouseMoved(MouseEvent event) {
            }
        }

        public void paintComponent(Graphics page) {
            super.paintComponent(page);
            page.setColor(Color.yellow);

            Polygon p;

            // add existing polygons
            for (int i = 0; i < plist.size(); i++) {
                p = plist.get(i);
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

            // draw a current polygon
            if ((p1 != null) && (p2 != null)) {
                switch (currentType) {
                    case LINE:
                        page.drawLine(p1.x, p1.y, p2.x, p2.y);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
                        page.drawOval(p1.x - radius, p1.y - radius, radius * 2, radius * 2);
                        break;
                    case RECTANGLE:
                        int width = Math.abs(p2.x - p1.x);
                        int height = Math.abs(p2.y - p1.y);
                        int rx = Math.min(p1.x, p2.x);
                        int ry = Math.min(p1.y, p2.y);
                        page.drawRect(rx, ry, width, height);
                        break;
                    default:
                } // end of switch
            } // end of if
        } // end of paintComponent
    } // end of DrawPanel
} // end of RubberLinePanel
