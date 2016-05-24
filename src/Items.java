/*
 * child of Character that designates all in game items. 
 * Variables in this class will determine the abilities of the specific item
 */
public class Items extends Character{
	
	public Items(int charId, int start, int r, int c, Space[][] space){
		super(charId, start, r, c,space);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub 
		return 0;
	}
	
	public String toString(){
		return "Item";
	}

}
