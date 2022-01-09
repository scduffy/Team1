import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		Location[] moves = {myLoc.shift(0, 1), myLoc.shift(0, -1), myLoc.shift(1, 0), myLoc.shift(-1, 0)};

		for (Location l : moves) {
			if (myMap.getLoc(l) != null && !myMap.getLoc(l).isEmpty() && !myMap.getLoc(l).contains(Map.Type.WALL)) {
				valid_moves.add(l);
			}
		}
		return valid_moves;
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
    
		if (moves.isEmpty()){
			return false;
		}

		Random random = new Random();
		int move = random.nextInt(moves.size());
		myLoc = moves.get(move);
		myMap.move(myName,moves.get(move),Map.Type.GHOST);
		return true;
	}

	public boolean is_pacman_in_range() {
		ArrayList<Location> movesAvailable = get_valid_moves();
		movesAvailable.add(myLoc);
		
		for (Location l : movesAvailable) {
			if (myMap.getLoc(l).contains(Map.Type.PACMAN))
				return true;
		}
		return false;
	}

	public boolean attack() {
		if (is_pacman_in_range()) {
			ArrayList<Location> valid_moves = get_valid_moves();
			for(Location move : valid_moves) {
				if(myMap.getLoc(move).contains(Map.Type.PACMAN)) {
					boolean attacked = myMap.attack(this.myName);
					if(attacked) {
						myLoc = move;
					}
					return attacked;
				}
			}
		}
		return false;
	}
	}
}
