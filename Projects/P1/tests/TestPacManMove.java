import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		//Creating A Map
		Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		
		//Creating Players
		PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y
		assertTrue(pacman.move());
		pacman = frame.addPacMan(new Location(0, 0));
		assertFalse(pacman.move());
	}
}
