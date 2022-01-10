import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		//Creating A Map
		MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(2, 1), "stinky", Color.red);
		assertTrue(ghost.move());
		ghost = frame.addGhost(new Location(0, 0), "ghost", Color.blue);
		assertFalse(ghost.move());
	}
}
