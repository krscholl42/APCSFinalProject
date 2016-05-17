/*
 * parent class for all 'living' objects in game (ie: Player, Monsters)
 */
public abstract class Character implements Comparable{
	protected final int startHealth;
	protected int currentHealth;
	protected final int charId;
	protected Location loc;
	
	public Character(int charId,int start, int r, int c){
		this.charId = charId;
		startHealth = start;
		currentHealth = startHealth;
		loc = new Location(r,c);
	}
	
	
	public int getHealth(){
		return 0;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public int compareTo(Character o) {
		if(charId == o.getCharId())
			return 1;
		return 0;
	}


	public int getCharId() {
		return charId;
	}

}
