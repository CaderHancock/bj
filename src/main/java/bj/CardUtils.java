package bj;

public class CardUtils{

    public static int sumHand(Hand hand){
        return hand.getCards().stream()
            .mapToInt(CardUtils::gameValue)
            .sum();
    }
    private static boolean handHasAce(Hand hand) {
        return hand.getCards().contains(Card.ACE);
    }
    private static Integer gameValue(Card card) {
        return switch (card){
            case TWO -> 2;
            case ACE -> 11;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN, JACK, QUEEN, KING -> 10;
            case CUTCARD -> null;
        };
    }

    public boolean isBust(Hand hand){

        return sumHand(hand) > 21;
    }
}