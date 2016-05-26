import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

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
	JTextField jTextField1;
	TextField tf;
	ControlP5 cp5;
	String[] textfieldNames = {"Health", "Items Left", "Monsters Left", "Total Points Earned", "tf5"};

	public void setup() {
		size(640, 550); // set the size of the screen.
		setLayout(new FlowLayout());
 
		dun = new Dungeon(50, 50);
		dun.buildDungeon();
		initComponents();
		// Create a simulator

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, 620, 530);
		textField = new Display(this, 10, 550, 250, 200);

		// Set different grid values to different colors
		//		display.setColor(1, color(255, 0, 0)); 
		//		display.setColor(2, color(0, 255, 0));

		// You can use classes instead, for example:
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
		  for(String name: textfieldNames){
		    cp5.addTextfield(name)
		       .setPosition(20,y)
		       .setSize(100,40)
		       .setFont(font)
		       .setFocus(true)
		       .setColor(color(255,0,255))
		       .setText("testing")
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
	
	private void initComponents(){
        JTextField jTextField1 = new javax.swing.JTextField();
        
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
	}
	
	 public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == e.VK_UP) dun.handleEvent(Dungeon.KeyAction.UP);
	        if (e.getKeyCode() == e.VK_DOWN) dun.handleEvent(Dungeon.KeyAction.DOWN);
	        if (e.getKeyCode() == e.VK_RIGHT) dun.handleEvent(Dungeon.KeyAction.RIGHT);
	        if (e.getKeyCode() == e.VK_LEFT) dun.handleEvent(Dungeon.KeyAction.LEFT);
	    }

	    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
	        if (evt.getKeyCode() == evt.VK_UP) dun.handleEvent(Dungeon.KeyAction.UP);
	        if (evt.getKeyCode() == evt.VK_DOWN) dun.handleEvent(Dungeon.KeyAction.DOWN);
	        if (evt.getKeyCode() == evt.VK_RIGHT) dun.handleEvent(Dungeon.KeyAction.RIGHT);
	        if (evt.getKeyCode() == evt.VK_UP) dun.handleEvent(Dungeon.KeyAction.LEFT);

	    }//GEN-LAST:event_formKeyTyped
	    
	    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
	        if (evt.getKeyChar() == '\n') {
				String command = jTextField1.getText();
	            jTextField1.setText("");
	            //dun.handleCommand(command);
	        }
	    }//GEN-LAST:event_jTextField1KeyTyped

	@Override
	public void draw() {
		background(200);
		count++;
		if(count == 25){
			changeText("woot");
		}
		display.drawGrid(dun); // display the game
		

	}
	public void changeText(String text){
		Textfield txt = (Textfield) cp5.getController("Health");
		txt.setValue(text);
	}
}