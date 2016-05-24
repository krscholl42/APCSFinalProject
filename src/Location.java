/**
 * A class representing a location.  This class is just a container to store a row and column.
 * It has two uses.
 * 
 * First, to return a row and column from a method we need a single object that holds both.
 * This object is it.
 * 
 * Second, to provide some general helper methods having to do with direction.  For example,
 * if we at row 3 and column 2 and we head northeast, where are we now?
 * 
 * This class provides methods to answer those sorts of questions.
 * @author David
 */
public class Location {
        public static final int NORTH = 0, NORTHEAST = 1, EAST = 2, SOUTHEAST = 3, SOUTH = 4, SOUTHWEST = 5, WEST = 6, NORTHWEST = 7;
        public int row, col;
        
        public Location(int r, int c) {
            row = r;
            col = c;
        }
        
        public Location locationInDirection(int direction) {
            return Location.locationInDirection(this, direction);
        }     
        public static Location locationInDirection(Location loc, int direction) {
            Location n = new Location(loc.row, loc.col);    // don't change input!
            if (direction == NORTH) n.row--;
            if (direction == SOUTH) n.row++;
            if (direction == EAST) n.col++;
            if (direction == WEST) n.col--;
            
            return n;
        }
        
        public int getRow(){
        	return row;
        }
        
        public int getCol(){
        	return col;
        }
        
        public Location changeLoc(int r, int c){
        	row = r;
        	col = c;
        	return this;
        }
}
