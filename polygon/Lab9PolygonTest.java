package gui2;

import java.awt.BorderLayout;
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


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

