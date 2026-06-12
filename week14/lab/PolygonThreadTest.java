package gui2;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

import myNet.Messenger;



public class PolygonThreadTest {
	public static void main(String [] args) {
		SharedData dt = new SharedData();
		PolygonDraw pdraw1 = new PolygonDraw(dt);
        PolygonDraw pdraw2 = new PolygonDraw(dt);
        
        pdraw1.start();
        pdraw2.start();
	}
		
}
class PolygonDraw extends Thread {
		RubberLinePanelThread rpanel;
		ArrayList<Polygon> plist;
		SharedData sdata;
	PolygonDraw(SharedData d) {
		sdata = d;
		rpanel= new RubberLinePanelThread(sdata);
		plist= rpanel.plist;
	}
	
	public void run() {
		JFrame frame = new JFrame ("Rubber Lines"); 
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		
		Container cp = frame.getContentPane();
		
		cp.add (rpanel);
		frame.pack();
		frame.setVisible(true);
	}
}