package answers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PlayGame {

	public PlayGame(int setPlayerNum, String setPlayerName) {

		try {
			PlayerCards cards = null;
			PlayersHand tempHand = null;
			PokerHand tempWin = null;
			new GeneratePlayers(setPlayerNum);
			FileOperations data = new FileOperations("poker.txt");
			cards = new PlayerCards(data.openFile(), setPlayerNum,
					setPlayerName);

			HashMap<String, Integer> ranks = new HashMap<String, Integer>();
			LinkedHashMap<String, String[]> playerforGame = cards.getData();
			for (String player : playerforGame.keySet()) {

				tempHand = new PlayersHand(playerforGame.get(player));
				tempWin = new PokerHand(tempHand);
				ranks.put(player, tempWin.getRank());
			}

			System.out.println(ranks.values());
			new CheckRanks(ranks, playerforGame);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
