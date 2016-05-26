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

	public boolean pickUpItem(Location itemLoc){
		RoomSpace i = (RoomSpace) spaces[itemLoc.getRow()][itemLoc.getCol()];
		return i.remove(dungeon.ITEM_ID);
	}
	
	public void attacked(){
		currentHealth-= 5;
	}
	
//	public boolean attackMonster(Location monsterLoc){
//		RoomSpace i = (RoomSpace) spaces[monsterLoc.getRow()][monsterLoc.getCol()];
//		System.out.println("RoomRow: " + monsterLoc.getRow() + " RoomCol: " + monsterLoc.getCol());
//		return i.remove(dungeon.MONSTER_ID);
//	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
