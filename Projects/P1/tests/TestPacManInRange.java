import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		
		Ghost ghost1 = frame.addGhost(new Location(1, 1), "Karen", Color.red);
		Ghost ghost2 = frame.addGhost(new Location(1, 5), "LeeroyJenkins", Color.blue);
		PacMan pacman = frame.addPacMan(new Location(1, 2));

		assertFalse(ghost2.is_pacman_in_range());
		assertTrue(ghost1.is_pacman_in_range());
	}
}
