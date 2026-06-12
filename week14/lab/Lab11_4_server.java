package week14.lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab11_4_server {
    private static final List<Polygon> serverPlist = Collections.synchronizedList(new ArrayList<>());
    private static ServerPanel canvas;

    public static void main(String[] args) {
        // Start GUI
        JFrame frame = new JFrame("Polygon Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new ServerPanel();
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Start Network Server
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("Polygon Server started on port 9000...");
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ServerPanel extends JPanel {
        public ServerPanel() {
            setBackground(Color.black);
            setPreferredSize(new Dimension(600, 400));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.yellow);
            g.drawString("Total Received Polygons: " + serverPlist.size(), 15, 30);

            // Create a copy of the list to prevent ConcurrentModificationException while drawing
            List<Polygon> copy;
            synchronized (serverPlist) {
                copy = new ArrayList<>(serverPlist);
            }

            for (Polygon p : copy) {
                if (p instanceof Circle) {
                    Circle c = (Circle) p;
                    g.drawOval(c.x - c.radius, c.y - c.radius, c.radius * 2, c.radius * 2);
                } else if (p instanceof Rectangle) {
                    Rectangle r = (Rectangle) p;
                    g.drawRect(r.x, r.y, r.width, r.height);
                } else if (p instanceof Line) {
                    Line l = (Line) p;
                    g.drawLine(l.x, l.y, l.x2, l.y2);
                }
            }
        }
    }

    private static class ServerHandler extends Thread {
        private final Socket socket;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                @SuppressWarnings("unchecked")
                ArrayList<Polygon> receivedList = (ArrayList<Polygon>) ois.readObject();
                if (receivedList != null) {
                    serverPlist.addAll(receivedList);
                    System.out.println("Received " + receivedList.size() + " polygons. Total: " + serverPlist.size());
                    canvas.repaint();
                }
            } catch (Exception e) {
                System.err.println("Error reading from client: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {
                    // ignore
                }
            }
        }
    }
}
