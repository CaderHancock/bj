package bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player{

	public enum PlayerActions {STAY, HIT, DOUBLEDOWN, SPLIT}
	private List<Hand> hand;
	private final Integer bankroll;
	public final Integer bet = 1;
        private Set<PlayerActions> availableActions;

	public Player(Integer bankroll){

		hand = new ArrayList<>();
		this.bankroll = bankroll;
	}
	private Set<PlayerActions> getAvailableActions(){

        return availableActions;
	}
	public List<Hand> getHand() {
		return hand;
	}

	public void setHand(List<Hand> hand) {
		this.hand = hand;
	}
    public void setAvailableActions(Set<PlayerActions> availableActions) {
        this.availableActions = availableActions;
    }

}
