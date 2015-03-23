package answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CheckRanks {

	private LinkedHashMap<String, String[]> playerCards;
	private HashMap<String, Integer> ranks;
	private TreeMap<Integer, String> sortedRanks;
	private String winner = null;
	private int highestRank;
	private List<String> tiedWinners;

	public String getWinner() {
		return winner;
	}

	public CheckRanks(HashMap<String, Integer> setRanks,
			LinkedHashMap<String, String[]> setPlayerCards) {
		playerCards = setPlayerCards;
		ranks = setRanks;

		sortedRanks = new TreeMap<Integer, String>();
		for (String player : ranks.keySet()) {
			sortedRanks.put(ranks.get(player), player);
		}

		tiedWinners = new ArrayList<String>();
		highestRank = 0;
		for (Entry<String, Integer> rank : ranks.entrySet()) {
			if (rank.getValue() == sortedRanks.lastKey()) {
				highestRank += 1;
				tiedWinners.add(rank.getKey());
			}
		}

		if (highestRank == 1) {
			checkOneWinner();
		} else {
			checkMultiWinner();
		}

	}

	public String checkOneWinner() {
		this.winner = sortedRanks.get(sortedRanks.lastKey());
		System.out.println(winner + " Wins!");
		return winner;
	}

	public String checkMultiWinner() {
		HighestHand win = new HighestHand(tiedWinners, sortedRanks.lastKey(), playerCards);
		winner = win.getWinner();
		return winner;
	}

}
