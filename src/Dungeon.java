
public class Dungeon {
	protected Space[][] spaces;
	private final int width = 100;
	private final int height = 100;
	
	public Dungeon(){
		spaces = new Space[width][height];
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
	}

	private void fillRest() {
		for(int r = 0; r < width; r++){
			for(int c = 0; c < height; c++){
				Space current = spaces[r][c];
				if(current == null){
					if(adjacentRoom(r, c)){
						current = new WallSpace(r, c);
					}else{
						current = new EmptySpace(r, c);
					}
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

}
