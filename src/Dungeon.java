

public class Dungeon {
	protected Space[][] spaces;
	protected int player_r;
	protected int player_c;
	public final int ITEM_ID = 1;
	public final int PLAYER_ID = 0;
	public final int MONSTER_ID = 2;
	private final int width = 100;
	private final int height = 100;
	private final int ITEM_HEALTH = 1;
	private final int MONSTER_HEALTH = 50;
	private final int PLAYER_HEALTH = 100;
	private final int INIT_ITEMS = 15;
	private final int INIT_MONSTERS = 25;
	public Player player;
	
	public enum KeyAction {
        RIGHT, LEFT, UP, DOWN
    };
	
	public Dungeon(int playerR, int playerC){
		spaces = new Space[width][height];
		player_r = playerR;
		player_c = playerC;
	}
	
	public void buildDungeon(){
		
		for(int r = 25; r < 75; r++){
			for(int c = 25; c < 75; c++){
				spaces[r][c] = new RoomSpace(r,c);
			}
		}		
		for(int r = 0; r < 25; r++){
			int c = 49;
			spaces[r][c] = new RoomSpace(r,c);
		}
		fillRest();
		addItems(INIT_ITEMS);
		addMonsters(INIT_MONSTERS);
		placePlayer(player_r, player_c);
	}

	public void fillRest() {
		for(int r = 0; r < width; r++){
			for(int c = 0; c < height; c++){
				Space current = spaces[r][c];
				if(current == null){
					if(adjacentRoom(r, c)){
						current = new WallSpace(r, c);
					}else{
						current = new EmptySpace(r, c);
					}
					spaces[r][c] = current;
				}
			}
		}	
	}

	private boolean adjacentRoom(int r, int c) {
		if(r != 0 && spaces[r-1][c] instanceof RoomSpace)
			return true;
		if(c!= 0 && spaces[r][c-1] instanceof RoomSpace)
			return true;
		if(r != 0 && c!= 0 && spaces[r-1][c-1] instanceof RoomSpace)
			return true;
		if(r != width-1 && spaces[r+1][c] instanceof RoomSpace)
			return true;
		if(c != height-1 && spaces[r][c+1] instanceof RoomSpace)
			return true;
		if(r != 0 && c != height-1 && spaces[r-1][c+1] instanceof RoomSpace)
			return true;
		if(r != width-1 && c!= 0 && spaces[r+1][c-1] instanceof RoomSpace)
			return true;
		if(r != width-1 && c != height-1 && spaces[r+1][c+1] instanceof RoomSpace)
			return true;
		
		return false;
	}
	
	private void addItems(int numItems){
		while(numItems > 0){
			int r = (int)(Math.random()*width);
			int c = (int)(Math.random()*height);
			if(spaces[r][c] instanceof RoomSpace){
				numItems --;
				spaces[r][c].add(new Items(ITEM_ID, ITEM_HEALTH,r,c,spaces));
			}
		}
	}
	
	public void addMonsters(int numMons){
		while(numMons > 0){
			int r = (int)(Math.random()*width);
			int c = (int)(Math.random()*height);
			if(spaces[r][c] instanceof RoomSpace){
				numMons --;
				spaces[r][c].add(new Monster(MONSTER_ID, MONSTER_HEALTH,r,c, spaces));
				System.out.println("MONSTER!");
			}
		}
	}
	
	public void placePlayer(int r, int c){
		if(spaces[r][c] instanceof RoomSpace){
			if(spaces[r][c].getIsFull()){
				Character thing = ((RoomSpace) spaces[r][c]).getMVT();
				((RoomSpace) spaces[r][c]).remove(thing);
			}

			player = new Player(PLAYER_ID, PLAYER_HEALTH, r, c, spaces);
			spaces[r][c].add(player);

			spaces[r][c].add(new Player(PLAYER_ID, PLAYER_HEALTH, r, c, spaces));
			System.out.println("PLAYER!");

		}
		
			
	}
	
    public void handleEvent(KeyAction e) {
        if (e == KeyAction.RIGHT) {
            player.move(Location.EAST);
        }
        if (e == KeyAction.LEFT) {
            player.move(Location.WEST);
        }
        if (e == KeyAction.UP) {
            player.move(Location.NORTH);
        }
        if (e == KeyAction.DOWN) {
            player.move(Location.SOUTH);
        }
    }
	
	public Space[][] getGrid(){
		return spaces;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
