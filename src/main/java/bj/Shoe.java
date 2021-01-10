package bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shoe {

	public Iterator<Card> getCardIterator() {
		return cards;
	}

	private Iterator<Card> cards;

	public Shoe(Integer decks) {

		ArrayList<Card> deckInit = new ArrayList<>();
		while (!deckInit.contains(Card.CUTCARD))
			deckInit = initShoe(decks);

		cards = deckInit.iterator();
	}

	private ArrayList<Card> initShoe(Integer decks) {
		ArrayList<Card> deckInit = new ArrayList<>();
		addDecks(decks, deckInit);
		Collections.shuffle(deckInit);
		insertCutCard(deckInit);
		return deckInit;
	}

	private void addDecks(Integer decks, ArrayList<Card> deckInit) {
		for (int i = 0; i < decks * 4; i++) {
			deckInit.addAll(List.of(Card.TWO, Card.THREE, Card.FOUR, Card.FIVE, Card.SIX, Card.SEVEN, Card.EIGHT,
					Card.NINE, Card.TEN, Card.JACK, Card.QUEEN, Card.KING, Card.ACE));
		}
	}

	private void insertCutCard(ArrayList<Card> deckInit) {
		int length = deckInit.size();
		int higherBound = length - length / 5;
		int lowerBound = higherBound - length / 10;

		int index = (int) ((Math.random() * (higherBound - lowerBound)) + lowerBound);
		deckInit.add(index, Card.CUTCARD);
	}

	public Card next() {
		if (cards.next().equals(Card.CUTCARD)) {
			throw new RuntimeException("CUTCARD");

		} else
			return cards.next();
	}
}
