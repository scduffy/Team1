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
		return null;	
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();

		if (moves.isEmpty()){
			return false;
		}
		
		for(Location l: moves){
			if (myMap.getLoc(l).contains(Map.Type.COOKIE)){
				myLoc = l;
				myMap.move(myName,l,Map.Type.PACMAN);
				return true;
			}
		}

		Random random = new Random();
		int move = random.nextInt(moves.size());
		myLoc = moves.get(move);
		myMap.move(myName,moves.get(move),Map.Type.PACMAN);

		return true;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return (myMap.getLoc(myLoc).contains(Map.Type.COOKIE) ? myMap.eatCookie(myName) : null);
	}
}
