/*
 * what type of space each grid in the dungeon is. ex: RoomSpace, WallSpace, EmptySpace. 
 * Each Space grid will be able to hold one Character token and up to two Item tokens
 */
public abstract class Space {

	protected Location loc;
	
	public Space(int r, int c){
		loc = new Location(r,c);
		
	}

}
