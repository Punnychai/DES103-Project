package RIGHT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RightSide extends JPanel implements ActionListener, ItemListener {
	JPanel controlP = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	public static JLabel coffeeSelected = new JLabel();
	public static JLabel coffeeTempSelect = new JLabel();
	public static JComponent addChocCB = new JCheckBox("+ extra Chocolate Syrup "); //Implicit Casting (created as JCheckBox, declared as JComponent)
	public static JLabel addChocLB = new JLabel();
	public static JRadioButton hotBT = new JRadioButton("HOT");
	public static JRadioButton icedBT = new JRadioButton("ICED");
	JPanel TempPanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JButton OKBT = new JButton("OK");
	JButton resetBT = new JButton("RESET");
	private Color white = Color.white;
	public Color black = Color.black;
	public static int validMenu = 0;
	public int cupCoor = -110;
	public int coffeeCoor = 380;
	private int randomColor;
	
	Timer cupTimer = new Timer(5, this);
	Timer coffeeTimer = new Timer(1, this);
	
	Timer STOPWATCH = new Timer(1000, this);
	private int stopwatchTime = 0;
	
	public RightSide() {
		OKBT.addActionListener(this);
		resetBT.addActionListener(this);
		addChocCB.setVisible(false);		//Only appears when you select Mocha.
		hotBT.addActionListener(this);
		hotBT.addItemListener(this);
		icedBT.addActionListener(this);
		icedBT.addItemListener(this);
		((JCheckBox) addChocCB).addActionListener(this);	//Explicit Casting
		((JCheckBox) addChocCB).addItemListener(this);
		controlP.setLayout(new GridLayout(2,1));
		TempPanel.setLayout(new GridLayout(2,1));
		TempPanel.setBackground(white);
		ButtonPanel.setLayout(new GridLayout(1,2));
		addChocCB.setBackground(white);
		hotBT.setBackground(white);
		icedBT.setBackground(white);
		OKBT.setBackground(new Color(100, 255, 100));
		resetBT.setBackground(new Color(255, 100, 100));
		topPanel.setBackground(white);
		topPanel.setLayout(new GridLayout(4,1));
		this.setLayout(new GridLayout(2,1));
		this.add(controlP);
		controlP.add(topPanel);
		controlP.add(bottomPanel);
		topPanel.add(coffeeSelected);
		topPanel.add(coffeeTempSelect);
		topPanel.add(addChocCB);
		topPanel.add(addChocLB);
		TempPanel.add(hotBT);
		TempPanel.add(icedBT);
		ButtonPanel.add(OKBT);
		ButtonPanel.add(resetBT);
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(TempPanel, BorderLayout.NORTH);
		bottomPanel.add(ButtonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == OKBT) {
			if (validMenu == 0) {		//DIDN'T select Temperature
				coffeeSelected.setForeground(Color.red);
				coffeeSelected.setText("Please select a valid menu :(");
				coffeeTempSelect.setText(" ");
				hotBT.setSelected(false);
				icedBT.setSelected(false);
			}
			if (validMenu == 1) {		//Valid HOT menu
				System.out.println("HOT coffee is valid");
				cupTimer.start();
			}
			if (validMenu == 2) {		//Valid ICED menu
				System.out.println("ICED coffee is valid");
				cupTimer.start();
			}
			if (validMenu == 3) {		//Valid NON COFFEE menu (set in coffeeMachine)
				System.out.println("NON COFFEE is valid");
				cupTimer.start();
				randomColor = (int) (Math.random() * 3);
				System.out.println("Random Color :" + randomColor);
			}
		}
		if (e.getSource() == resetBT) {		//Resets EVERYTHING
			coffeeSelected.setText(" ");
			coffeeTempSelect.setText(" ");
			addChocCB.setVisible(false);
			addChocLB.setText(" ");
			hotBT.setSelected(false);
			icedBT.setSelected(false);
			((JCheckBox) addChocCB).setSelected(false);
			cupTimer.stop();
			cupCoor = -110;
			coffeeTimer.stop();
			coffeeCoor = 380;
			STOPWATCH.stop();
			stopwatchTime = 0;
		}
		if(e.getSource() == addChocCB) {
			addChocLB.setText("Added CHOCOLATE SYRUP");
			if (((JCheckBox)addChocCB).isSelected() == false) {		//Explicit Casting
				addChocLB.setText(" ");
			}
		}
		if (e.getSource() == cupTimer) {
			cupCoor++;
			if (cupCoor == 90) {
				cupTimer.stop();
				coffeeTimer.start();
			}
		}
		if (e.getSource() == coffeeTimer) {
			coffeeCoor++;
			STOPWATCH.start();
		}
		if (e.getSource() == STOPWATCH) {
			stopwatchTime++;
			System.out.println(stopwatchTime);
		}
		if (stopwatchTime == 7) {
			coffeeTimer.stop();
			STOPWATCH.stop();
			coffeeCoor = 700;		//Out of the frame
			coffeeTempSelect.setForeground(new Color(0, 130, 0));
			if (validMenu == 1 || validMenu == 2) {
				coffeeSelected.setText(" ");
				coffeeTempSelect.setText("Your Coffee is Ready");
			}
			if (validMenu == 3) {
				coffeeSelected.setText(" ");
				coffeeTempSelect.setText("Your Drink is Ready");
			}
			addChocCB.setVisible(false);
			addChocLB.setText(" ");
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		coffeeTempSelect.setForeground(black);
		if (e.getSource() == hotBT && e.getStateChange() == 1) { // HOT
			icedBT.setSelected(false);
			if(coffeeSelected.getText() == "You've selected Espresso") {	//Espresso
				coffeeTempSelect.setText("HOT ESPRESSO is a classic ;)");
				validMenu = 1;
			}
			if(coffeeSelected.getText() == "You've selected Americano") {	//Americano
				coffeeTempSelect.setText("HOT AMERICANO is selected");
				validMenu = 1;
			}
			if(coffeeSelected.getText() == "You've selected Mocha") {		//Mocha
				coffeeTempSelect.setText("HOT MOCHA is selected");
				validMenu = 1;
				addChocCB.setVisible(true);
			}
			if(coffeeSelected.getText() == "You've selected Cappuccino") {	//Cappuccino
				coffeeTempSelect.setText("HOT CAPPUCCINO is selected");
				validMenu = 1;
			}
			if(coffeeSelected.getText() == "You've selected Latte") {		//Latte
				coffeeTempSelect.setText("HOT LATTE is so Nice and Smooth!");
				validMenu = 1;
			}
			if(coffeeSelected.getText() == "You've selected Special Menu \"French Press\"") {	//French Press
				coffeeTempSelect.setForeground(Color.red);
				coffeeTempSelect.setText("French Press can only be serve in COLD :(");
				validMenu = 4; //Exceptional, We don't serve this menu.
			}
			if(coffeeSelected.getText() == "You've selected Special Menu \"Chemex\"") {			//Chemex
				coffeeTempSelect.setText("HOT CHEMEX is selected, so stylish!");
				validMenu = 1;
			}
		}
		if (e.getSource() == icedBT && e.getStateChange() == 1) { // ICED
			hotBT.setSelected(false);
			if (coffeeSelected.getText() == "You've selected Espresso") {	//Espresso
				coffeeTempSelect.setText(" ICED ESPRESSO, Thai Style, is selected");
				validMenu = 2;
			}
			if (coffeeSelected.getText() == "You've selected Americano") {	//Americano
				coffeeTempSelect.setText(" ICED AMERICANO is so cool, isn't it?");
				validMenu = 2;
			}
			if (coffeeSelected.getText() == "You've selected Mocha") {		//Mocha
				coffeeTempSelect.setText(" ICED MOCHA is selected");
				validMenu = 2;
				addChocCB.setVisible(true);
			}
			if (coffeeSelected.getText() == "You've selected Cappuccino") { //Cappuccino
				coffeeTempSelect.setText(" ICED CAPPUCCINO for hot summer days!");
				validMenu = 2;
			}
			if (coffeeSelected.getText() == "You've selected Latte") {		//Latte
				coffeeTempSelect.setText(" ICED LATTE is selected");
				validMenu = 2;
			}
			if (coffeeSelected.getText() == "You've selected Special Menu \"French Press\"") {	//French Press
				coffeeTempSelect.setText(" ICED FRENCH PRESS is selected");
				validMenu = 2;
			}
			if (coffeeSelected.getText() == "You've selected Special Menu \"Chemex\"") {		//Chemex
				coffeeTempSelect.setText(" ICED CHEMEX is a Bold choice ;)");
				validMenu = 2;
			}
		}
		else  if (coffeeTempSelect.getText() == " "){
			validMenu = 0;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(175, 175, 175));	//background
		g.fillRect(47,300,176,250);
		int[] bottomX = {0, 47, 223, 270};
		int[] bottomY = {670, 550, 550, 670};
		int[] leftX = {0, 0, 47, 47};
		int[] leftY = {0, 670, 550, 0};
		int[] rightX = {223, 223, 270, 270};
		int[] rightY = {0, 550, 670, 0};
		g.setColor(new Color(140, 140, 140)); 	//bottom and sides
		g.fillPolygon(bottomX, bottomY, 4);
		g.fillPolygon(leftX, leftY, 4);
		g.fillPolygon(rightX, rightY, 4);
		g.setColor(Color.black);
		g.drawLine(47, 300, 47, 550);
		g.drawLine(223,300,223,550);
		g.drawPolyline(bottomX, bottomY, 4);
		g.setColor(new Color(27, 18, 0));		//brewer
		g.fillRect(105, 350, 20, 20);
		g.fillRect(145, 350, 20, 20);
		g.setColor(new Color(80, 80, 80));
		g.drawRect(105, 350, 20, 20);
		g.drawRect(145, 350, 20, 20);
		g.setColor(new Color(220, 220, 220));
		g.fillOval(90, 275, 90, 90);
		g.setColor(new Color(80, 80, 80));
		g.drawOval(90, 275, 90, 90);
		
		g.setColor(white);						//coffee cup	
		g.fillOval(cupCoor, 600, 90, 30);
		g.setColor(black);
		g.drawOval(cupCoor, 600, 90, 30);
		g.setColor(white);
		g.fillRect(cupCoor+1, 602, 89, 17);
		g.setColor(black);
		g.drawOval(cupCoor, 590, 90, 30);
		if (validMenu == 1) {
			g.setColor(new Color(204, 50, 50));		//HOT
		}
		if (validMenu == 2) {
			g.setColor(new Color(0, 100, 190));		//ICED
		}
		if (validMenu == 3) {						//NON COFFEE (random cup color)
			if (randomColor == 0) {
				g.setColor(new Color(255, 200, 200));
			}
			if (randomColor == 1) {
				g.setColor(new Color(200, 250, 200));
			}
			if (randomColor == 2) {
				g.setColor(new Color(200, 200, 255));
			}	
		}
		g.fillOval(cupCoor, 590, 90, 30);
		int[] CupX = {cupCoor, cupCoor+90, cupCoor+100, cupCoor-10};
		int[] CupY = {605, 605, 480, 480};
		g.fillPolygon(CupX, CupY, 4);
		g.setColor(new Color(220, 220, 220));
		g.fillOval(cupCoor-10, 465, 110, 30);
		if (stopwatchTime == 7) {		//When coffee drop is already finished, cup will be filled	
			if (validMenu == 1 || validMenu == 2) {
				g.setColor(new Color(70, 45, 20));
			}
			if (validMenu == 3) {
				g.setColor(new Color(185, 230, 250));
			}
			g.fillOval(cupCoor-10, 465, 110, 30);
		}
		g.setColor(black);
		g.drawOval(cupCoor-10, 465, 110, 30);
		g.drawLine(cupCoor, 605, cupCoor-10, 480);
		g.drawLine(cupCoor+90, 605, cupCoor+100, 480);
		repaint();
		
		if (cupCoor == 90) {
			if (validMenu == 1 || validMenu == 2) {
				g.setColor(new Color(70, 45, 20));
			}
			if (validMenu == 3) {
				g.setColor(new Color(185, 230, 250));
			}
			g.fillOval(105, coffeeCoor, 20, 20);
			g.fillOval(145, coffeeCoor, 20, 20);
			int[] triX1 = {105, 125, 115};
			int[] triX2 = {145, 165, 155};
			int[] triY = {coffeeCoor+7, coffeeCoor+7, coffeeCoor-10};
			g.fillPolygon(triX1, triY, 3);
			g.fillPolygon(triX2, triY, 3);
			if (coffeeCoor == 475) {
				coffeeCoor = 380;
			}
		}
		repaint();
	}
}
