import java.awt.event.KeyEvent;

import processing.core.*;

public class GUI extends PApplet {
	int c;
	Display display;
	Dungeon dun;

	public void setup() {
		size(640, 550); // set the size of the screen.
 
		dun = new Dungeon(50, 50);
		dun.buildDungeon();
		// Create a simulator

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, 620, 530);

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

	@Override
	public void draw() {
		background(200);
		
		display.drawGrid(dun); // display the game
		
	}
}