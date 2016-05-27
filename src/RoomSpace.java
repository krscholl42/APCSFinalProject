/*
 * child of Space that designates places where Characters and Items can be placed. 
 */
public class RoomSpace extends Space{
	public Character[] contains;
	private int index;
	private final int MONSTER_ID = 2;
	private final int PLAYER_ID = 0;
	
	public RoomSpace(int r, int c){
		super(r,c);
		isFull = false;
		contains = new Character[3];
		index = 0;
	}
	
	public boolean isSpaceFull(){
		if(index > 0)
			return true;
		return false;
	}
	
	public Character getFirstThing(){
		return contains[0];
	}
	
	public Character getMVT(){ //Most Valuable Thing (if only items, returns first thing)
		boolean monster = false;
		boolean item = false;
		int index = 0;
		for(int i = 0; i < contains.length; i++){
			if(contains[i] instanceof Player)
				return contains[i];
			if(contains[i] instanceof Monster){
				monster = true;
				index = i;
			}
		}
		if(monster == true)
			return contains[index];
		return contains[0];
		
	}
	
	public boolean add(Character thing){
		if(isFull == false){
			contains[index] = thing;
			index++;
			isFull = isSpaceFull();
			return true;
		}else
			return false;
	}
	
	public boolean remove(int charId){
		boolean there = false;
		Character[] nextContains = new Character[contains.length];
		int nextIndex = 0;
		for(int i = 0; i < index; i++){
			if(contains[i].getCharId() == charId && there == false){
				there = true;
			}else{
				nextContains[nextIndex] = contains[i];
				nextIndex++;
			}
		}
		 contains = nextContains;
		 index = nextIndex;
		 
		return there;
	}
	
	public boolean  isEmpty(){
		boolean empty = true;
		for(int i = 0; i< contains.length; i++){
			if(contains[i] != null)
				empty = false;
		}
		return empty;
	}
	
	public int moveAMonster(){
		int moved = -1;
		if(contains(2, 0)){
			for(int i = 0; i < index; i++){
				if(contains[i].getCharId() == MONSTER_ID){
					Monster m = (Monster) contains[i];
					moved = m.randomMove();
				}
			}
		}
		return moved;
	}
	
	public boolean contains(int charId, int origId){
		if(charId == origId)
			return false;
		for(int i = 0; i < index; i++){
			if(contains[i].getCharId() == charId){
				return true;
			}
		}
		return false;
	}
}

	

	
