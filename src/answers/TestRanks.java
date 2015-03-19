package answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class TestRanks {

	public static void main(String[] args) {
		String[] names = { "Florita", "player2", "player3" };
		int[] rank = new int[] { 0, 0, 0 };
		List<String> card = new ArrayList<String>();
		card.add("2D JC 5S QS 7D");
		card.add("9C AC TC KD 2H");
		card.add("4D 3D 6C 8H 5C");
		LinkedHashMap<String, String[]> cards = new LinkedHashMap<String, String[]>();
		HashMap<String, Integer> ranks = new HashMap<String, Integer>();
		for (int x = 0; x <= 2; x++) {
			String[] hand = card.get(x).split(" ");
			cards.put(names[x], hand);
			ranks.put(names[x], rank[x]);
		}
		new CheckRanks(ranks, cards);
	}

}
