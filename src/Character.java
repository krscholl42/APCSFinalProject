/*
 * parent class for all 'living' objects in game (ie: Player, Monsters)
 */
public abstract class Character {
	protected final int startHealth;
	protected int currentHealth;
	protected Location loc;
	
	public Character(int start, int r, int c){
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

}
