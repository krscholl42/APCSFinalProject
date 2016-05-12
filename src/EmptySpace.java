
public class EmptySpace extends Space {
	
	public EmptySpace(int r, int c){
		super(r,c);
		isFull = true;
	}

	@Override
	public boolean add(Character thing) {
		//returns false is isFull = true
		return false;
		
	}

}
