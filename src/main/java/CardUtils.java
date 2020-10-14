public class CardUtils{


	public static int sumHand(Hand hand){

		if(handHasAce(hand)) {
			return 0;
		}
		return hand.getCards().stream().mapToInt(card -> gameValue(card)).sum();

	}

	private static boolean handHasAce(Hand hand) {
		return hand.getCards().contains(Card.ACE);
	}

	private static Integer gameValue(Card card) {
		 return switch (card){
			case ONE -> 1;
			case TWO -> 2;
			 case THREE -> 3;
			 case FOUR -> 4;
			 case FIVE -> 5;
			 case SIX -> 6;
			 case SEVEN -> 7;
			 case EIGHT -> 8;
			 case NINE -> 9;
			 case TEN, JACK, QUEEN, KING -> 10;
			 case ACE -> null;
			 case CUTCARD -> {
				 yield null;
			 }
		 };
	}

	public boolean isBust(Hand hand){

	    return sumHand(hand) > 21;
    }
}
