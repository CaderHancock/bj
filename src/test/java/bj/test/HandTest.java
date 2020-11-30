package bj.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import bj.Card;
import bj.Hand;
import org.junit.jupiter.api.Test;

public class HandTest {

  @Test
  public void givenTwoEqualHands_whenEqualityTested_thenReturnTrue() {
    final Hand hand = new Hand(0);
    hand.addCard(Card.TEN);
    hand.addCard(Card.ACE);
    final Hand hand1 = new Hand(0);
    hand1.addCard(Card.ACE);
    hand1.addCard(Card.TEN);
    assertTrue(hand.equals(hand1));
  }

  @Test
  public void givenTwoUnequalHands_whenEqualityTested_thenReturnFalse() {
    final Hand hand = new Hand(0);
    hand.addCard(Card.SIX);
    hand.addCard(Card.TEN);
    final Hand hand1 = new Hand(0);
    hand1.addCard(Card.ACE);
    hand1.addCard(Card.TEN);

    assertFalse(hand.equals(hand1));
  }

  @Test
  public void givenTwoHandsOfEqualValueWithDifferentCardsNOACE_whenCompareToCalled_thenReturnZero() {
    Hand hand1 = new Hand(0);
    Hand hand2 = new Hand(0);
    hand1.addCard(Card.NINE);
    hand1.addCard(Card.SIX);
    hand2.addCard(Card.TEN);
    hand2.addCard(Card.FIVE);
    assertTrue(0 == hand1.compareTo(hand2));
  }
}
