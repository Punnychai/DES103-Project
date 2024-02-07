package machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import LEFT.Coffee;
import LEFT.NonCoffee;
import RIGHT.RightSide;

public class CoffeeMachine extends JFrame implements ActionListener {
	Coffee Coffee = new Coffee();
	NonCoffee NonCoffee = new NonCoffee();
	RightSide rightside = new RightSide();
	
	CoffeeMachine() {
		setSize(550,700);
		setVisible(true);
		setTitle("COFFEE Machine");
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(Coffee);
		add(rightside);
		
		Coffee.nonCofBT.addActionListener(this);
		NonCoffee.CofBT.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		new CoffeeMachine();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Coffee.nonCofBT) {
			getContentPane().remove(Coffee);
			getContentPane().remove(rightside);
			add(NonCoffee);
			add(rightside);
			RIGHT.RightSide.hotBT.setVisible(false);
			RIGHT.RightSide.icedBT.setVisible(false);
			RIGHT.RightSide.validMenu = 3; //Valid NON COFFEE menu
			revalidate();
		}
		if (e.getSource() == NonCoffee.CofBT) {
			getContentPane().remove(NonCoffee);
			getContentPane().remove(rightside);
			add(Coffee);
			add(rightside);
			RIGHT.RightSide.hotBT.setVisible(true);
			RIGHT.RightSide.icedBT.setVisible(true);
			revalidate();
		}
		RIGHT.RightSide.coffeeSelected.setText(" ");
		RIGHT.RightSide.coffeeTempSelect.setText(" ");
		RIGHT.RightSide.addChocCB.setVisible(false);
		RIGHT.RightSide.addChocLB.setText(" ");
		
	}
}
