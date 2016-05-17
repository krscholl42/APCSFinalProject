/*
 * Character controlled by the human player in game. Child of the Character class
 */
public class Player extends Character{
	
	public Player(int charId, int start, int r, int c){
		super(charId, start, r, c);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
