/*
 * child of Space that designates places where Characters and Items can be placed. 
 */
public class RoomSpace extends Space {
	
	public RoomSpace(int r, int c){
		super(r,c);
		isFull = false;
	}
	
	public boolean isSpaceFull(){
		// checks to see if there is one player, one monster, or two items in the space. If yes, returns true. Else, returns false
		
		return false;
	}

}
