import java.awt.Color;
import java.io.FileNotFoundException;
import junit.framework.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();

		PacMan pacman1 = frame.addPacMan(new Location(2, 1));
		Ghost ghost1 = frame.addGhost(new Location(5, 10), "ghost1", Color.red);
		Ghost ghost2 = frame.addGhost(new Location(1, 1), "ghost2", Color.blue);

		assertFalse(frame.getMap().attack("ghost1"));
		assertTrue(frame.getMap().attack("ghost2"));

	}
}
