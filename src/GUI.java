import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import controlP5.ControlEvent;
import controlP5.ControlP5;
import controlP5.Controller;
import controlP5.Textfield;
import javafx.scene.text.Text;
import processing.core.*;

public class GUI extends PApplet {
	int c; int count;
	Display display;
	Display textField;
	Dungeon dun;
	ControlP5 cp5;
	String[] textfieldNames = {"Health", "Items Left", "Monsters Left", "Total Points Earned", "Time Left"};
	String[] textfieldTexts = {"100", "15", "25", "0", "150"};
	PFont f; 
	int ItemsCurrent;
	int ItemsNext;
	int totalPoints;
	int healthNext;
	int health;
	int time;
	
	boolean gameOver;
	boolean won;

	public void setup() {
		size(640, 550); // set the size of the screen.
		setLayout(new FlowLayout());		
		f = createFont("Georgia", 48, true);
 
		dun = new Dungeon(50, 50);
		dun.buildDungeon();
		// Create a simulator
		
		ItemsCurrent = dun.getItemCount();
		ItemsNext = ItemsCurrent;
		totalPoints = 0;
		health = 100;
		time = 150;
		
		gameOver = false;
		won = false;
		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, 620, 530);
		textField = new Display(this, 10, 550, 250, 200);

		display.setColor(RoomSpace.class, color(0, 0, 255));
		display.setColor(WallSpace.class, color(247, 116, 59));
		display.setColor(EmptySpace.class, color(0,0,0));
		display.setColor(Space.class, color(87,123,243));
		display.setColor(Player.class, color(255,0,200));
		display.setColor(Items.class, color(255,255,245));
		display.setColor(Monster.class, color(0,255,0));

		display.setNumCols(dun.getWidth());
		display.setNumRows(dun.getHeight());

		PFont font = createFont("arial",20);

		  cp5 = new ControlP5(this);

		  int y = 20;
		  int spacing = 60;
		  for(int i = 0; i < textfieldNames.length; i++){
			  String name = textfieldNames[i];
			  cp5.addTextfield(name)
		       .setPosition(20,y)
		       .setSize(100,40)
		       .setFont(font)
		       .setFocus(true)
		       .setColor(color(255,0,255))
		       .setText(textfieldTexts[i])
		       ;
		     y += spacing;
		  }

		  textFont(font);
	}
	
	void controlEvent(ControlEvent theEvent) {
		  if(theEvent.isAssignableFrom(Textfield.class)) {
		    println("controlEvent: accessing a string from controller '"
		            +theEvent.getName()+"': "
		            +theEvent.getStringValue()
		            );
		  }
	}

	
	 public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == e.VK_UP) dun.handleEvent(Dungeon.KeyAction.UP);
	        if (e.getKeyCode() == e.VK_DOWN) dun.handleEvent(Dungeon.KeyAction.DOWN);
	        if (e.getKeyCode() == e.VK_RIGHT) dun.handleEvent(Dungeon.KeyAction.RIGHT);
	        if (e.getKeyCode() == e.VK_LEFT) dun.handleEvent(Dungeon.KeyAction.LEFT);
	        if (e.getKeyCode() == e.VK_I) dun.handleEvent(Dungeon.KeyAction.ITEM);
	    }

	    @Override
	public void draw() {
		background(200);
		ItemsNext = dun.getItemCount();
		healthNext = dun.player.getHealth();
		
		if(ItemsNext != ItemsCurrent){
			changeCount(textfieldNames[1], ItemsNext);
			ItemsCurrent = ItemsNext;
			if(totalPoints == 0)
				totalPoints += 20;
			if(totalPoints <= 0)
				totalPoints = 0;
			totalPoints = (int) (totalPoints*1.2);
			changeCount(textfieldNames[3], totalPoints);
		}
		if(healthNext != health){
			health = healthNext;
			changeCount(textfieldNames[0], health);
			totalPoints -= 20;
			changeCount(textfieldNames[3], totalPoints);
		}
		
		if((count+1) % 15 == 0){
			monsterAction();
		}
		if((count+1) % 105 == 0){
			time--;
			changeCount(textfieldNames[4], time);
		}
		
		if(health == 0 || time == 0){
			gameOver = true;
		}
		if(ItemsCurrent == 0){
			gameOver = true;
			won = true;
			totalPoints += (int)time*1.5;
		}		
		if(!gameOver){
			display.drawGrid(dun); // display the game
			count++;
		}else if(gameOver == true){
			textFont(f);
			fill(0);
			textAlign(CENTER);
			if(won == true){
				text("YOU WON!!! \n You earned a total of " + totalPoints,275, 350);
			}else{
				text("You lost...\n You earned a total of " + totalPoints,275, 350);
			}
		}
		

	}
	private void monsterAction() {
		dun.moveMonsters();		
		}

	private void changeCount(String txtName, int nextCount) {
			Textfield txt = (Textfield) cp5.getController(txtName);
			String num = Integer.toString(nextCount);
			txt.setValue(num);		
		}

	public void changeText(String text){
		Textfield txt = (Textfield) cp5.getController("Health");
		txt.setValue(text);
	}
}