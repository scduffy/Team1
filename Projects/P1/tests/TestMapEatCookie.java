import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException{
		MainFrame frame = new MainFrame();
		Map map = frame.getMap();

		PacMan pacman = frame.addPacMan(new Location(1, 1));
		
		assertTrue(map.eatCookie("pacman") != null);
		assertTrue(map.eatCookie("pacman") == null); // Cookie at (1,1) already eaten
	}
}
