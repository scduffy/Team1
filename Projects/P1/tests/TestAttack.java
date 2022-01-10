import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		MainFrame frame = new MainFrame();

		Ghost ghost1 = frame.addGhost(new Location(1, 1), "ghost1", Color.red);
		Ghost ghost2 = frame.addGhost(new Location(5, 9), "ghost2", Color.blue);

		PacMan pacman = frame.addPacMan(new Location(6, 9));
		assertTrue(ghost1.attack() == false);
		assertTrue(ghost2.attack());
	}
}

