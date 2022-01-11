import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase {

	public void testMapMove() throws FileNotFoundException {
		MainFrame frame = new MainFrame();

		Ghost ghost1 = frame.addGhost(new Location(1, 1), "ghost1", Color.red);
		Ghost ghost2 = frame.addGhost(new Location(5, 9), "ghost2", Color.blue);
		PacMan pacman = frame.addPacMan(new Location(6, 9));
		assertTrue(frame.getMap().move("pacman", new Location(6, 9), Map.Type.PACMAN));

	}
}
