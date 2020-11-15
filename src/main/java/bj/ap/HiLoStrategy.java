package bj.ap;

import bj.Card;

public class HiLoStrategy implements CountStrategy {
    @Override
    public int strategyValue(Card card) {
        return switch (card){
            case TWO, THREE, FOUR, FIVE, SIX -> 1;
            case SEVEN, EIGHT, NINE, CUTCARD -> 0;
            case TEN, JACK, QUEEN, KING, ACE -> -1;
        };
    }
}