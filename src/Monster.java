/*
 * child class of Character and parent class for all attack based monsters in game.
 * More sub-species of Monster will be implemented once the basic game is finished
 */
public class Monster extends Character{
	
	public Monster(int charId, int start, int r, int c, Dungeon d){
		super(charId, start, r, c,d);
		
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean randomMove() {
		int direction = (int)(Math.random()*9);
		Location moveTo = Location.locationInDirection(loc, direction);

		if (dungeon.isOpen(moveTo.row, moveTo.col)) {
			dungeon.moveElementAt(loc, direction);

			loc = moveTo; // update own location
			return true;
		}

		return false;
		
	}
}
