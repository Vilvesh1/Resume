/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab5
 * Before starting to paint Points in DemoModel.java with different Colors, the Point array in DemoModel.java should be changed to an ArrayList<Point>. 
 * This will avoid out of bounds errors. 
 * You should do this first and ensure that your changes work before going on to other tasks.
 * DemoModel.java already stores the Color that the user has selected. Change PaintPanel.java to draw the Points using this Color. 
 * [Hint: There is a method in Graphics to change the drawing Color.] 
 * This change should result in all the Points between drawn using the currently selected Color, which is not quite what is desired.
 * So that Points can be drawn in different Colors, DemoModel.java needs to store a Color for each point.
 * This could be done using an ArrayList<Color> and adding a Color to this ArrayList every time a Point is added.
 * Finally, PaintPanel.java needs to be able to access the Colors stored in DemoModel.java.
 * Create a getColor method in DemoModel.java that will return the Color at a given index. 
 * This can be similar to the GetPoint method. 
 * Now PaintPanel.java can be changed to use this method to obtain a Color for each Point.
 */

package demovc;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * This demonstrates the model-view-controller design pattern.
 * Adapted from Figures 14.23 and 14.34.
 * @author Tom Bylander
 */
public class DemoMVC {
	/**
	 * main method starts the application
	 */
	public static void main(String[] args) {
		DemoModel model = new DemoModel();
		DemoView view = new DemoView(model);
		DemoController controller = new DemoController(model, view);
		
		// register controller as the listener
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}
}

