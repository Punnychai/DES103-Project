package LEFT;

import java.awt.event.*;

public class CoffeeListener extends RIGHT.RightSide implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		coffeeSelected.setForeground(black);
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 140 && e.getY() <= 180) { //Espresso
			coffeeSelected.setText("You've selected Espresso");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 200 && e.getY() <= 240) { //Americano
			coffeeSelected.setText("You've selected Americano");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 260 && e.getY() <= 300) { //Mocha
			coffeeSelected.setText("You've selected Mocha");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 320 && e.getY() <= 360) { //Cappuccino
			coffeeSelected.setText("You've selected Cappuccino");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 380 && e.getY() <= 420) { //Latte
			coffeeSelected.setText("You've selected Latte");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 440 && e.getY() <= 480) { //French Press
			coffeeSelected.setText("You've selected Special Menu \"French Press\"");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 500 && e.getY() <= 540) { //Chemex
			coffeeSelected.setText("You've selected Special Menu \"Chemex\"");
		}
		coffeeTempSelect.setText(" ");
		hotBT.setSelected(false);
		icedBT.setSelected(false);
		addChocCB.setVisible(false);
	}

	public void mousePressed(MouseEvent e) { }

	public void mouseReleased(MouseEvent e) { }
	
	public void mouseEntered(MouseEvent e) { }

	public void mouseExited(MouseEvent e) { }
	
}
