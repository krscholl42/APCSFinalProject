/*
 * parent class for all 'living' objects in game (ie: Player, Monsters)
 */
public abstract class Character{
	protected final int startHealth;
	protected int currentHealth;
	protected final int charId;
	protected Location loc;
	protected final int LEFT = 1;
	protected final int UP = 0;
	protected final int DOWN = 2;
	protected final int RIGHT = 3;
	public Dungeon dungeon;
	public Space[][] spaces;
	
	public Character(int charId,int start, int r, int c, Dungeon d){
		this.charId = charId;
		startHealth = start;
		currentHealth = startHealth;
		dungeon = d;
		spaces = d.getGrid();
		loc = new Location(r,c);
	}
	
	public int getHealth(){
		return currentHealth;
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


	public int getCharId() {
		return charId;
	}

	public int[] isAdjacent(Location loc, int charId){
		int[] rowCol = new int[2];
		rowCol[0] = -1; rowCol[1] = -1;
		for(int r = -1; r <= 1; r++){
			for(int c = -1; c <= 1; c++){
				if(dungeon.isInRoom((loc.getRow()+r), (loc.getCol()+c))){
					Space adj = spaces[(loc.getRow()+r)][(loc.getCol()+c)];
					if(adj instanceof RoomSpace){
						if((((RoomSpace) adj).contains(charId, getCharId()))){
							rowCol[0] = adj.loc.getRow(); rowCol[1] = adj.loc.getCol();
							return rowCol;
						}
					}
					
				}
			}
		}
		return rowCol;
	}

}
