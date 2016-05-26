/*
 * child of Space that designates places where Characters and Items can be placed. 
 */
public class RoomSpace extends Space{
	private Character[] contains;
	private int index;
	
	public RoomSpace(int r, int c){
		super(r,c);
		isFull = false;
		contains = new Character[3];
		index = 0;
	}
	
	public boolean isSpaceFull(){
		// checks to see if there is one player, one monster, or two items in the space. If yes, returns true. Else, returns false
		int itemCount = 0;
		isFull = false;
		for(int i = 0; i < contains.length; i++){
			if(contains[i] instanceof Monster || contains[i] instanceof Player)
				isFull = true;
			else if(contains[i] instanceof Items)
				itemCount++;
		}
		if(itemCount >= 2)
			isFull = true;
	
		return isFull;
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
		for(int i = 0; i <= index; i++){
			System.out.println(i);
			if(contains[i].getCharId() == charId && there == false){
				there = true;
			}else{
				nextContains[i] = contains[i];
			}
		}
		 contains = nextContains;
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
	
	public boolean contains(int charId){
		if(charId == 0)
			return false;
		System.out.println("yo " + charId);
		System.out.println("index:" + index);
		for(int i = 0; i < index; i++){
			System.out.println("i: " + i + " charId: " + contains[i].getCharId());
			if(contains[i].getCharId() == charId){
				System.out.println("if");
				return true;
			}
		}
		System.out.println("nah");
		return false;
	}
}

	

	
