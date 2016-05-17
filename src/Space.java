/*
 * what type of space each grid in the dungeon is. ex: RoomSpace, WallSpace, EmptySpace. 
 * Each Space grid will be able to hold one Character token and up to two Item tokens
 */
public abstract class Space implements Comparable {
	protected Location loc;
	protected boolean isFull;
	
	public Space(int r, int c){
		loc = new Location(r,c);
		
	}
	
	public boolean getIsFull(){
		return isFull;
	}
	
	public abstract boolean add(Character thing);
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
