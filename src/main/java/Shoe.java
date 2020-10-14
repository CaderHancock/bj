import java.util.*;

class Shoe{

	public Iterator<Card> getCards() {
		return cards;
	}

	private Iterator<Card> cards;
	public Shoe(Integer decks){

		ArrayList<Card> deckInit = new ArrayList<>();

		for (int i = 0; i < decks*4; i++){
			deckInit.addAll(List.of(
				Card.ONE,
				Card.TWO,
				Card.THREE,
				Card.FOUR,
				Card.FIVE,
				Card.SIX,
				Card.SEVEN,
				Card.EIGHT,
				Card.NINE,
				Card.TEN,
				Card.JACK,
				Card.QUEEN,
				Card.KING,
				Card.ACE));
		}

		Collections.shuffle(deckInit);
		insertCutCard(deckInit);
		cards = deckInit.iterator();
	}

	private void insertCutCard(ArrayList<Card> deckInit) {
		int length = deckInit.size();
		int higherbound = length - length/5;
		int lowerBound = higherbound -	length/10;
		int index = (int) ((Math.random() * (higherbound - lowerBound)) + lowerBound);

		deckInit.add(index, Card.CUTCARD);
	}
}
