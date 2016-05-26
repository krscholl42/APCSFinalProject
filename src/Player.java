/*
 * Character controlled by the human player in game. Child of the Character class
 */
public class Player extends Character{
	public Player(int charId, int start, int r, int c, Dungeon d){
		super(charId, start, r, c, d);
	}
	
	public boolean move(int direction){
		Location moveTo = Location.locationInDirection(loc, direction);

		if (dungeon.isOpen(moveTo.row, moveTo.col)) {
			dungeon.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
	}
	
	public boolean isAdjacent(Location loc, int charId){
		for(int r = -1; r <= 1; r++){
			for(int c = -1; c <= 1; c++){
				if(dungeon.isInRoom(loc.getRow()+r, loc.getCol()+c)){
					Space adj = spaces[loc.getRow()+r][loc.getCol()+c];
					if(adj instanceof RoomSpace){
						if((((RoomSpace) adj).contains(charId)))
							return true;
					}
					
				}
			}
		}
		return false;
	}
	public Location whereAdjacent(Location loc, int charId){
		for(int r = -1; r <= 1; r++){
			for(int c = -1; c <= 1; c++){
				if(dungeon.isInRoom(loc.getRow()+r, loc.getCol()+c)){
					Space adj = spaces[loc.getRow()+r][loc.getCol()+c];
					if(adj instanceof RoomSpace){
						if((((RoomSpace) adj).contains(charId)))
							return new Location(r,c);
					}
					
				}
			}
		}
		return new Location(-1,-1); //should theoretically never happen, but if it does, sends an invalid location
	}
	
	public boolean pickUpItem(Location itemLoc){
		RoomSpace i = (RoomSpace) spaces[itemLoc.getRow()][itemLoc.getCol()];
		return i.remove(dungeon.ITEM_ID);
	}
	
	public boolean attackMonster(Location monsterLoc){
		RoomSpace i = (RoomSpace) spaces[monsterLoc.getRow()][monsterLoc.getCol()];
		return i.remove(dungeon.MONSTER_ID);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(){
		return "Player";
	}

}
