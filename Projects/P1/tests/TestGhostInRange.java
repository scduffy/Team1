import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		MainFrame frame = new MainFrame();

		Ghost ghost1 = frame.addGhost(new Location(1, 1), "ghost1", Color.red);
		Ghost ghost2 = frame.addGhost(new Location(5, 9), "ghost2", Color.blue);

		PacMan pacman = frame.addPacMan(new Location(6, 9));
		assertTrue(pacman.is_ghost_in_range());

		MainFrame frame1 = new MainFrame();

		Ghost ghost_1 = frame1.addGhost(new Location(1, 1), "ghost_1", Color.red);
		Ghost ghost_2 = frame1.addGhost(new Location(5, 9), "ghost_2", Color.blue);

		PacMan pacman1 = frame1.addPacMan(new Location(7, 9));
		assertTrue(pacman1.is_ghost_in_range() == false);

	}
}

