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
}
