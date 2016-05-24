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
