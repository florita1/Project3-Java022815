package answers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HighestHand {

	private int rank;
	private String winner;
	private List<String> winners;
	private LinkedHashMap<String, String[]> playerCards;
	private LinkedHashMap<String, Integer> cardValues = null;

	public HighestHand(List<String> setWinners, int setRank,
			LinkedHashMap<String, String[]> setPlayerCards) {
		setCardValues();
		winners = setWinners;
		playerCards = setPlayerCards;
		rank = setRank;
		chooseWinner();
	}
	
	public String getWinner() {
		return winner;
	}

	public int getHighCard(String[] testHand) {
		int cardVal = 0;
		for (String x : testHand) {
			for (String c : cardValues.keySet()) {
				if (x.substring(0, 1).equals(c)) {
					if (cardVal <= cardValues.get(c)) {
						cardVal = cardValues.get(c);
					}
				}
			}
		}
		// System.out.println(cardVal);
		return cardVal;
	}

	public int getHighHand(String[] testHand) {
		int handVal = 0;
		for (String x : testHand) {
			handVal += cardValues.get(x.substring(0, 1));
		}
		// System.out.println(handVal);
		return handVal;
	}

	public String chooseWinner() {
		TreeMap<Integer, String> winnerMap = new TreeMap<Integer, String>();

		if (rank == 0) {
			for (String player : winners) {
				for (Entry<String, String[]> map : playerCards.entrySet())
					if (map.getKey().equals(player)) {
						winnerMap.put(getHighCard(map.getValue()), player);
					}
			}
		} else {
			for (String player : winners) {
				for (Entry<String, String[]> map : playerCards.entrySet())
					if (map.getKey().equals(player)) {
						winnerMap.put(getHighHand(map.getValue()), player);
					}
			}
		}
		System.out.println(winnerMap.get(winnerMap.lastKey()) + " wins!");
		winner = winnerMap.get(winnerMap.lastKey());
		return winner;
	}

	public LinkedHashMap<String, Integer> getCardValues() {
		return cardValues;
	}

	public void setCardValues() {
		this.cardValues = new LinkedHashMap<String, Integer>();
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J",
				"Q", "K", "A" };
		int val = 0;
		for (String card : cards) {
			this.cardValues.put(card, val += 1);
		}
	}

}
