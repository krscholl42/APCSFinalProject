
public class EmptySpace extends Space {
	
	public EmptySpace(int r, int c){
		super(r,c);
	}

	@Override
	public boolean add(Character thing) {
		return false;	
	}
}
