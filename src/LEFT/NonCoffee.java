package LEFT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NonCoffee extends JPanel implements MouseMotionListener {
	public JButton CofBT = new JButton("Coffee");
	boolean[] drinkState = new boolean[] {false, false};
	private MouseListener LeftMouseListener = new NonCoffeeListener();
	
	public NonCoffee() {
		this.setBackground(Coffee.bgColor);
		this.setLayout(new BorderLayout());
		CofBT.setBackground(new Color(240, 190, 240));
		this.add(CofBT, BorderLayout.SOUTH);
		this.addMouseMotionListener(this);
		this.addMouseListener(LeftMouseListener);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.drawString("Non Coffee Menus Here!", 15, 60);
		g.setFont(new Font("Tahoma", Font.ITALIC, 15));
		g.drawString("Menu :", 15, 120);
		
		g.setColor(Coffee.buttonColor);
		g.fillRect(15, 140, 235, 40);
		g.fillRect(15, 200, 235, 40);
		g.setFont(new Font("SansSerif", Font.PLAIN, 25));
		g.setColor(Color.black);
		g.drawString("Mineral Water", 40, 170);
		g.drawString("Tonic Water", 40, 230);
		
		if(drinkState[0]) {
			g.setColor(Coffee.buttonSelected);
			g.fillRect(15, 140, 235, 40);
			g.setColor(Color.black);
			g.drawString("Mineral Water", 40, 170);
		}
		if(drinkState[1]) {
			g.setColor(Coffee.buttonSelected);
			g.fillRect(15, 200, 235, 40);
			g.setColor(Color.black);
			g.drawString("Tonic Water",40, 230);
		}
	}

	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 140 && e.getY() <= 180) { //Espresso
			drinkState[0] = true;
			repaint();
		}
		if (drinkState[0]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 140 || e.getY() >= 180) {
				drinkState[0] = false;
				repaint();
			}
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 200 && e.getY() <= 240) { //Americano
			drinkState[1] = true;
			repaint();
		}
		if (drinkState[1]) {
			if (e.getX() <= 15 || e.getX() >= 235 || e.getY() <= 200 || e.getY() >= 240) {
				drinkState[1] = false;
				repaint();
			}
		}	
	}
}
