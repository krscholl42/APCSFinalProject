/*
 * Character controlled by the human player in game. Child of the Character class
 */
public class Player extends Character{
	
	public Player(int charId, int start, int r, int c, Space[][] space){
		super(charId, start, r, c, space);
	}
	
	public void move(int direction){
		if(direction == UP){
			if(isValidMove(new Location(loc.getRow()-1, loc.getCol()))){
				loc = loc.changeLoc(loc.getRow()-1, loc.getCol());
			}
		}else if(direction == LEFT){
			if(isValidMove(new Location(loc.getRow(), loc.getCol()+1)))
				loc = loc.changeLoc(loc.getRow(), loc.getCol() +1);
		}else if(direction == DOWN){
			if(isValidMove(new Location(loc.getRow()+1, loc.getCol())))
				loc = loc.changeLoc(loc.getRow()+1, loc.getCol());
		}else if(direction == RIGHT){
			if(isValidMove(new Location(loc.getRow(), loc.getCol()-1)))
				loc = loc.changeLoc(loc.getRow(), loc.getCol()-1);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
