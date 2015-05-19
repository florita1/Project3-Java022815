package pokerGameTests;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import answers.PlayersHand;
import answers.PokerHand;

public class TestPokerHand {
	static PokerHand pHand;
	static String[] s1;

	@BeforeClass
	public static void createHand() {
		s1 = "JD QC KS AH 2D".split(" ");
		pHand = new PokerHand(new PlayersHand(s1));
	}

	@Test
	public void getRank() {
		int expected_output = pHand.getRank();
		assertEquals(expected_output, 0);
	}

}
