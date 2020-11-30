package bj;

public class CardUtils {

    public static int sumHand(Hand hand) {

        int rawValue = hand.getCards().stream().mapToInt(CardUtils::gameValue).sum();

        if (!handHasAce(hand))
            return rawValue;
        else {
            long numAces = hand.getCards().stream().filter(x -> x.equals(Card.ACE)).count();
            for (int i = 0; i < numAces; i++) {
                if (rawValue <= 21) {
                    return rawValue;
                }
                rawValue -= 10;
            }
        }
        return rawValue;
    }

    private static boolean handHasAce(Hand hand) {
        return hand.getCards().contains(Card.ACE);
    }

    public void method() {

    }

    private static Integer gameValue(Card card) {
        return switch (card) {
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

    public boolean isBust(Hand hand) {

        return sumHand(hand) > 21;
    }
}
