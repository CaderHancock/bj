package bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hand {

	private final List<Card> cards;
	private Integer bet;
	private Player.PlayerActions playerAction;
	public Hand(Integer bet){
		this.cards = new ArrayList<>();
		this.bet = bet;

	}
	public List<Card> getCards(){
		return this.cards;
	}
	public void  addCard(Card card){
		cards.add(card);
	}
	public Integer getBet() {
		return bet;
	}
	public void setBet(Integer bet) {
		this.bet = bet;
	}
	public Player.PlayerActions getPlayerAction() {
		return playerAction;
	}
	public void setPlayerAction(Player.PlayerActions playerAction) {
		this.playerAction = playerAction;
	}       
        public boolean equals(Hand hand){
        
            return hand.getCards().containsAll(this.cards) &&
                hand.getCards().size() == this.cards.size();

        }
}
