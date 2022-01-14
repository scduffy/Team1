import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Map map = frame.getMap();

		PacMan pacman = frame.addPacMan(new Location(1, 1));
		
		assertTrue(map.getCookies() == 0);
		assertTrue(map.eatCookie("pacman") != null);
		assertTrue(map.getCookies() == 1);
		assertTrue(map.eatCookie("pacman") == null); // Cookie at (1,1) already eaten
		assertTrue(map.getCookies() == 1); // No cookie consumed by second call to eatCookie
	}
}
