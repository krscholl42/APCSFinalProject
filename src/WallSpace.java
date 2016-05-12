
public class WallSpace extends Space {
	
	public WallSpace(int r, int c){
		super(r,c);
		isFull = true;
	}

	@Override
	public boolean add(Character thing) {

		return false;
	}

}
