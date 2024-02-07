package LEFT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Coffee extends JPanel implements MouseMotionListener {
	public JButton nonCofBT = new JButton("Non-Coffee");
	protected static Color bgColor = new Color(240, 250, 255);
	protected static Color buttonColor = new Color(230, 240, 255);
	protected static Color buttonSelected = new Color(215, 225, 255); 
	boolean[] coffeeState = new boolean[] {false, false, false, false, false, false,false};
	private MouseListener LeftMouseListener = new CoffeeListener();

	public Coffee() {
		this.setBackground(bgColor);
		this.setLayout(new BorderLayout());
		nonCofBT.setBackground(new Color(240,190,240));
		this.add(nonCofBT,BorderLayout.SOUTH);
		this.addMouseMotionListener(this);
		this.addMouseListener(LeftMouseListener);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.drawString("Hi, Fellow coffee enjoyer", 15, 60);
		g.setFont(new Font("Tahoma", Font.ITALIC, 15));
		g.drawString("Menu :", 15, 120);
		
		g.setColor(buttonColor);
		for (int i = 0; i < 7; i++) {
			g.fillRect(15, 140 +(i*60), 235, 40);
		}
		g.setFont(new Font("SansSerif", Font.PLAIN, 25));
		String [] menu = {"Espresso", "Americano", "Mocha", "Cappuccino", "Latte"};
		Color [] menuColors = {new Color(23,17,9), new Color(53,35,21), new Color(60,40,13), new Color(121,92,52), new Color(154,123,79)};
		for (int j = 0; j < 5; j++) {
			g.setColor(menuColors[j]);
			g.drawString(menu[j], 40, 170 +(j*60));
		}
		g.setFont(new Font("SansSerif", Font.BOLD, 18));
		g.setColor(Color.black);
		g.drawString("French Press", 115, 469);
		g.drawString("Chemex", 115, 530);
		g.setColor(new Color(254, 195, 15));
		g.drawString("SPECIAL", 30, 470);
		g.drawString("SPECIAL", 30, 530);
		
		if(coffeeState[0]) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(0*60), 235, 40);
			g.setColor(menuColors[0]);
			g.drawString(menu[0], 40, 170 +(0*60));
		}
		if(coffeeState[1]) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(1*60), 235, 40);
			g.setColor(menuColors[1]);
			g.drawString(menu[1], 40, 170 +(1*60));
		}
		if(coffeeState[2]) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(2*60), 235, 40);
			g.setColor(menuColors[2]);
			g.drawString(menu[2], 40, 170 +(2*60));
		}
		if(coffeeState[3] ) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(3*60), 235, 40);
			g.setColor(menuColors[3]);
			g.drawString(menu[3], 40, 170 +(3*60));
		}
		if(coffeeState[4]) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(4*60), 235, 40);
			g.setColor(menuColors[4]);
			g.drawString(menu[4], 40, 170 +(4*60));
		}
		if(coffeeState[5]) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(5*60), 235, 40);
			g.setFont(new Font("SansSerif", Font.BOLD, 16));
			g.setColor(new Color(254, 195, 15));
			g.drawString("SPECIAL", 30, 470);
			g.setColor(Color.black);
			g.drawString("French Press", 101, 469);
		}
		if(coffeeState[6]) {
			g.setColor(buttonSelected);
			g.fillRect(15, 140 +(6*60), 235, 40);
			g.setFont(new Font("SansSerif", Font.BOLD, 16));
			g.setColor(new Color(254, 195, 15));
			g.drawString("SPECIAL", 30, 530);
			g.setColor(Color.black);
			g.drawString("Chemex", 101, 530);		
		}
	}

	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 140 && e.getY() <= 180) { //Espresso
			coffeeState[0] = true;
			repaint();
		}
		if (coffeeState[0]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 140 || e.getY() >= 180) {
				coffeeState[0] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 200 && e.getY() <= 240) { //Americano
			coffeeState[1] = true;
			repaint();
		}
		if (coffeeState[1]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 200 || e.getY() >= 240) {
				coffeeState[1] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 260 && e.getY() <= 300) { //Mocha
			coffeeState[2] = true;
			repaint();
		}
		if (coffeeState[2]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 260 || e.getY() >= 300) {
				coffeeState[2] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 320 && e.getY() <= 360) { //Cappuccino
			coffeeState[3] = true;
			repaint();
		}
		if (coffeeState[3]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 320 || e.getY() >= 360) {
				coffeeState[3] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 380 && e.getY() <= 420) { //Latte
			coffeeState[4] = true;
			repaint();
		}
		if (coffeeState[4]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 380 || e.getY() >= 420) {
				coffeeState[4] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 440 && e.getY() <= 480) { //French Press
			coffeeState[5] = true;
			repaint();
		}
		if (coffeeState[5]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 440 || e.getY() >= 480) {
				coffeeState[5] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 500 && e.getY() <= 540) { //Chemex
			coffeeState[6] = true;
			repaint();
		}
		if (coffeeState[6]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 500 || e.getY() >= 540) {
				coffeeState[6] = false;
				repaint();
			}
		}
	}
}
