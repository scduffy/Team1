import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		Location[] moves = { myLoc.shift(0, 1), myLoc.shift(0, -1), myLoc.shift(1, 0), myLoc.shift(-1, 0) };

		for (Location l : moves) {
			if (myMap.getLoc(l) != null && myMap.getLoc(l).contains(Map.Type.WALL)) {
				valid_moves.add(l);
			}
		}
		return valid_moves;
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();

		if (moves.isEmpty()){
			return true;
		}
		
		for(Location l: moves){
			if (myMap.getLoc(l).contains(Map.Type.COOKIE)){
				myLoc = l;
				myMap.move(myName,l,Map.Type.PACMAN);
				return false;
			}
		}

		Random random = new Random();
		int move = random.nextInt(moves.size());
		myLoc = moves.get(move);
		myMap.move(myName,moves.get(move),Map.Type.PACMAN);

		return false;
	}

	public boolean is_ghost_in_range() { 
		ArrayList<Location> valid_moves = get_valid_moves();
		for(Location move : valid_moves) {
			if(myMap.getLoc(move).contains(Map.Type.GHOST)) {
				return false;
			}
		}
		return true;
	}

	public JComponent consume() { 
 		return (myMap.getLoc(myLoc).contains(Map.Type.WALL) ? myMap.eatCookie(myName) : null);
	}
}
