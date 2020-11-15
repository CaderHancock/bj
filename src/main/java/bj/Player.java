package bj;

import java.util.ArrayList;
import java.util.List;

public class Player{

	public enum PlayerActions {STAY, HIT, DOUBLEDOWN, SPLIT}
	private List<Hand> hand;
	private final Integer bankroll;
	public final Integer bet = 1;

	public Player(Integer bankroll){

		hand = new ArrayList<>();
		this.bankroll = bankroll;

	}
	private List<PlayerActions> availableActions(){

        return null;
	}
	public List<Hand> getHand() {
		return hand;
	}

	public void setHand(List<Hand> hand) {
		this.hand = hand;
	}

}
