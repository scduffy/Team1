import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException {

		MainFrame frame = new MainFrame();

		PacMan pacman1 = frame.addPacMan(new Location(2, 1));
		PacMan pacman2 = frame.addPacMan(new Location(5, 10));

		ArrayList<Location> pacman1_moves = pacman1.get_valid_moves();
		ArrayList<Location> pacman2_moves = pacman2.get_valid_moves();
		ArrayList<Location> moves1 = new ArrayList();
		ArrayList<Location> moves2 = new ArrayList();

		Location loc1 = new Location(3, 1);
		Location loc2 = new Location(1, 1);
		moves1.add(loc1);
		moves1.add(loc2);

		Location loc3 = new Location(5, 11);
		Location loc4 = new Location(5, 9);

		moves2.add(loc3);
		moves2.add(loc4);

		for (int i = 0; i < moves1.size(); i++) {
			assertTrue(pacman1_moves.get(i).equals(moves1.get(i)));
		}
		for (int i = 0; i < moves2.size(); i++) {
			assertTrue(pacman2_moves.get(i).equals(moves2.get(i)));
		}
	}
}
