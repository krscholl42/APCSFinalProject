import processing.core.*;

public class GUI extends PApplet {
	int c;
	Display display;
	Dungeon dun;

	public void setup() {
		size(640, 550); // set the size of the screen.

		dun = new Dungeon(75,75);
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
		display.setColor(Player.class, color(0,32,0));
		display.setColor(Items.class, color(0,0,20));

		display.setNumCols(dun.getWidth());
		display.setNumRows(dun.getHeight());


	}

	@Override
	public void draw() {
		background(200);
		
		display.drawGrid(dun); // display the game
	}
}