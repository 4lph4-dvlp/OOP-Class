package gui;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PolygonTest {


	public static void main(String [] args) {
		JFrame frame = new JFrame ("Rubber Lines"); 
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 

		Container cp = frame.getContentPane();
		//cp.setLayout(new BorderLayout());
		cp.add (new RubberLinePanel());
		frame.pack();
		frame.setVisible(true);
		
				
		
	}
}

class RubberLinePanel extends JPanel 
{
	ArrayList<Polygon> plist = new ArrayList<Polygon>();
	
	RubberLinePanel() {
		Circle c1= new Circle();
		Circle c2 = new Circle(20,20,50);
		Rectangle r1 = new Rectangle(20,20,100,200);
		Rectangle r2 = new Rectangle(100,100,300,50);
		System.out.println("rubberline");
		
		plist.add(c1);
		plist.add(c2);
		plist.add(r1);
		plist.add(r2);
		
		setPreferredSize (new Dimension(1000, 1000));
		add (new DrawPanel()); 
		
		
		
	}
	private class DrawPanel extends JPanel {
		public DrawPanel(){
			setBackground (Color.black); 
			setPreferredSize (new Dimension(500, 500));
		}
			
		public void paintComponent(Graphics page) {
			super.paintComponent(page);
					
			page.setColor(Color.yellow);
		
			Polygon p;
						
			for(int i = 0; i < plist.size(); i++) {
				p = plist.get(i);
				if(p instanceof Circle) {
					Circle c = (Circle)p;
				    page.drawOval(c.x - c.radius, c.y - c.radius, c.radius*2,c.radius*2 );  
				} else if (p instanceof Rectangle) {
					Rectangle r = (Rectangle)p;
				    page.drawRect(r.x, r.y, r.width,r.height );
				}		            
			}   
		}
	}
}