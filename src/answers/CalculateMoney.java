package answers;

import java.util.HashMap;
import java.util.Map.Entry;

public class CalculateMoney {
	
	private HashMap<String,Integer> oldWallets;
	private String winner;
	private int ante;
	
	public CalculateMoney(HashMap<String,Integer> setOldWallets, int setAnte, String setWinner) {
		ante = setAnte;
		winner = setWinner;
		oldWallets = setOldWallets;
		
	}
	
	public HashMap<String,Integer> recalculateMoney() {
		int newAmount = 0;
		HashMap<String,Integer> newWallets = new HashMap<String,Integer>();
		for(Entry<String,Integer> player : oldWallets.entrySet()) {
			if(player.getKey().equals(winner)) {
				newAmount = (player.getValue() + ( oldWallets.keySet().size() * ante));
				newWallets.put(winner,  newAmount);
			} else {
				newAmount = player.getValue() - ante;
				newWallets.put(player.getKey(), newAmount);
			}
		}
		return newWallets;
	}

}
