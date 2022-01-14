import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapGetLoc extends TestCase {

	public void testMapGetLoc() throws FileNotFoundException {

		NoFrame frame = new NoFrame(); 
		Map map = frame.getMap();
		assertTrue(map.getLoc(new Location(0, 0)).contains(Map.Type.WALL));
		assertTrue(map.getLoc(new Location(1, 1)).contains(Map.Type.COOKIE));

		PacMan pacman = frame.addPacMan(new Location(1, 1)); // Creates PacMan at location x, y
		assertTrue(map.getLoc(new Location(1, 1)).contains(Map.Type.PACMAN));
		pacman.consume();
		assertTrue(!map.getLoc(new Location(1, 1)).contains(Map.Type.COOKIE));

		pacman.move(); // move pacman away from (1,1)
		assertTrue(!map.getLoc(new Location(1, 1)).contains(Map.Type.PACMAN));

		Ghost ghost = frame.addGhost(new Location(1, 2), "Ghost", Color.red);
		assertTrue(map.getLoc(new Location(1, 2)).contains(Map.Type.GHOST));

	}
}
