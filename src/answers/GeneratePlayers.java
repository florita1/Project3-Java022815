package answers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePlayers {

	private int playerNum;
	private List<String> deckCards;

	public GeneratePlayers(int setPlayerNum) throws IOException {
		playerNum = setPlayerNum;
		generateDeckCards();
		makePlayerFile();

	}

	public void makePlayerFile() throws IOException {
		File file = new File("poker.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		String line = "";
		Collections.shuffle(deckCards);
		// Writes the content to the file
		int cardsInGame = 5 * playerNum;
		for (int x = 0; x <= cardsInGame - 1; x++) {
			line += deckCards.get(x) + " ";
		}
		writer.write(line);
		writer.close();
	}

	private void generateDeckCards() {
		deckCards = new ArrayList<String>();
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J",
				"Q", "K", "A" };
		String[] suits = { "S", "D", "C", "H" };

		String newCard = "";
		for (String suit : suits) {
			for (String card : cards) {
				newCard = card + suit;
				this.deckCards.add(newCard);
			}
		}
	}

}
