import processing.core.*;

public class GUI extends PApplet {
	int c;
	Display display;

	public void setup() {
		size(640, 550); // set the size of the screen.

		// Create a simulator

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, 620, 530);

		// Set different grid values to different colors
		//		display.setColor(1, color(255, 0, 0)); 
		//		display.setColor(2, color(0, 255, 0));

		// You can use classes instead, for example:
		display.setColor(RoomSpace.class, color(39, 243, 53));
		display.setColor(WallSpace.class, color(247, 116, 59));
		display.setColor(EmptySpace.class, color(0,0,0));
		display.setColor(Space.class, color(255,255,255));

		display.setNumCols(100);
		display.setNumRows(100);


	}

	@Override
	public void draw() {
		
	}
}