package bj;

import static bj.CardUtils.sumHand;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.jetbrains.annotations.NotNull;

public class Hand {

	private final List<Card> cards;
	private Integer bet;
	private EnumSet<HandActions> handAction;

	public Hand(final Integer bet) {
		this.cards = new ArrayList<>();
		this.bet = bet;
		this.handAction = EnumSet.noneOf(HandActions.class);

	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void addCard(@NotNull final Card card) {
		cards.add(card);
		this.refreshHandActions();
	}

	private void refreshHandActions() {
		// TODO find out what the rules are exactly
		handAction.add(HandActions.STAY);
	}

	public Integer getBet() {
		return bet;
	}

	public void setBet(final Integer bet) {
		this.bet = bet;
	}

	public boolean equals(final Hand hand) {

		return hand.getCards().containsAll(this.cards) && hand.getCards().size() == this.cards.size();

	}

	public int compareTo(final Hand hand) {
		final int thisHandsValue = sumHand(this);
		final int otherHandsValue = sumHand(hand);
		if (thisHandsValue == otherHandsValue)
			return 0;
		if (thisHandsValue > otherHandsValue)
			return 1;
		else
			return -1;
	}
}
