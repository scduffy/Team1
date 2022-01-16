import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE
	}


	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components;
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet;

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean move(String name, Location loc, Type type) {
		// update locations, components, and field
		// use the setLocation method for the component to move it to the new location
		if (locations.containsKey(name) || components.containsKey(name) || field.containsKey(loc)) {
			return false;
		}

		components.get(name).setLocation(loc.x, loc.y);
		field.get(locations.get(name)).remove(type);
		field.get(loc).add(type);
		locations.put(name, loc);

		return true;
	}

	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method
		return field.get(loc);
	}

	public boolean attack(String Name) {
		if (isGameOver()) {
			return gameOver;
		}

		Location ghostLocation = locations.get(Name);

		if (ghostLocation != null) {
			Location[] moves = { ghostLocation.shift(0, 1), ghostLocation.shift(0, -1), ghostLocation.shift(1, 0),
					ghostLocation.shift(-1, 0) };
			for (Location l : moves) {
				if (field.get(l) != null && field.get(l).contains(Map.Type.PACMAN)) {
					gameOver = true;
					return true;
				}
			}
		}
		return false;
	}

	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		Location loc = locations.get(name);
		String cookie = "tok_x" + loc.x + "_y" + loc.y;

		if (locations.get(cookie) != null) {
			locations.remove(cookie);
			cookies++;
			field.get(loc).remove(Type.COOKIE);
			JComponent c = components.get(cookie);
			components.remove(cookie);
			return c;
		}
		return null;
	}
}
