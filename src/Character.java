/*
 * parent class for all 'living' objects in game (ie: Player, Monsters)
 */
public abstract class Character implements Comparable{
	protected final int startHealth;
	protected int currentHealth;
	protected final int charId;
	protected Location loc;
	protected final int LEFT = 1;
	protected final int UP = 0;
	protected final int DOWN = 2;
	protected final int RIGHT = 3;
	protected Space[][] spaces;
	
	public Character(int charId,int start, int r, int c, Space[][] space){
		this.charId = charId;
		startHealth = start;
		currentHealth = startHealth;
		spaces = space;
		loc = new Location(r,c);
	}
	
	public int getHealth(){
		return 0;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public boolean isValidMove(Location nextLoc){
		int r = nextLoc.getRow();
		int c = nextLoc.getCol();
		Space next = spaces[r][c];
		
		if(next instanceof EmptySpace || next instanceof WallSpace)
			return false;
		if(next instanceof RoomSpace){
			if(!((RoomSpace) next).isSpaceFull())
				return true;
		}
		return false;
	}
	
	public int compareTo(Character o) {
		if(charId == o.getCharId())
			return 1;
		return 0;
	}


	public int getCharId() {
		return charId;
	}

}
