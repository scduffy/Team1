import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapGetLoc extends TestCase {

    public void testMapGetLoc() throws FileNotFoundException {
		
		MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		Map map = frame.getMap();
		assertEquals(map.getLoc(0,0), Map.Type.WALL);
		assertEquals(map.getLoc(1,1), Map.Type.COOKIE);
		
		PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y
		assertEquals(map.getLoc(1,1), Map.Type.PACMAN);
		pacman.consume();
		pacman.move(); // move pacman away from (1,1)
		assertEquals(map.getLoc(1,1), Map.Type.EMPTY);

		Ghost ghost = frame.addGhost(new Location(1, 2), "Ghost", Color.red);
		assertEquals(map.getLoc(1,2), Map.Type.GHOST);

	}
}
