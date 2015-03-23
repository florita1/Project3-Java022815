package answers;

import java.io.IOException;
import java.util.LinkedHashMap;

public class PlayerCards {

	private int numOfPlayers;
	private String playerName;
	private String[] playerNames;
	private String[] cards;
	private LinkedHashMap<String, String[]> playerMap;

	public PlayerCards(String[] setCards, int setNumOfPlayers,
			String setPlayerName) throws IOException {
		numOfPlayers = setNumOfPlayers;
		playerName = setPlayerName;
		playerNames = new String[] { playerName, "Player 2", "Player 3",
				"Player 4", "Player 5" };
		cards = setCards;
		makePlayers();

	}

	public void makePlayers() {
		playerMap = new LinkedHashMap<String, String[]>();
		for (int x = 0; x <= numOfPlayers - 1; x++) {
			playerMap.put(playerNames[x], new String[5]);
		}

	}

	public LinkedHashMap<String, String[]> getData() {
		String[] playerHand = new String[5];
		int cardCount = 0;
		int startVal = 0;
		for (String player : playerMap.keySet()) {
			for (int x = startVal; x <= startVal + 4; x++) {
				playerHand[cardCount] = cards[x];
				cardCount += 1;
				if (cardCount > 4) {
					playerMap.put(player, playerHand);
					startVal = x + 1;
					cardCount = 0;
					playerHand = new String[5];
					break;
				}
			}
		}

		return playerMap;

	}
}
