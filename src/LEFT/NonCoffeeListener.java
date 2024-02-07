package LEFT;

import java.awt.event.*;

public class NonCoffeeListener extends RIGHT.RightSide implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		coffeeSelected.setForeground(black);
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 140 && e.getY() <= 180) { //Espresso
			coffeeSelected.setText("You've seleted Mineral Water");
		}
		if (e.getX() >= 15 && e.getX() <= 235 && e.getY() >= 200 && e.getY() <= 240) { //Americano
			coffeeSelected.setText("You've Selected Tonic Water");
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
