import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		MainFrame frame = new MainFrame();

		Ghost ghost1 = frame.addGhost(new Location(1, 1), "ghost1", Color.red);
		Ghost ghost2 = frame.addGhost(new Location(5, 9), "ghost2", Color.blue);

		ArrayList<Location> ghost1_moves = ghost1.get_valid_moves();
		ArrayList<Location> ghost2_moves = ghost2.get_valid_moves();
		ArrayList<Location> moves1 = new ArrayList();
		ArrayList<Location> moves2 = new ArrayList();

		Location loc1 = new Location(1, 2);
		Location loc2 = new Location(2, 1);
		moves1.add(loc1);
		moves1.add(loc2);

		Location loc3 = new Location(5, 10);
		Location loc4 = new Location(5, 8);
		Location loc5 = new Location(6, 9);
		moves2.add(loc3);
		moves2.add(loc4);
		moves2.add(loc5);

		for (int i = 0; i < moves1.size(); i++) {
			assertTrue(ghost1_moves.get(i).equals(moves1.get(i)));
		}
		for (int i = 0; i < moves2.size(); i++) {
			assertTrue(ghost2_moves.get(i).equals(moves2.get(i)));
		}

	}
}
