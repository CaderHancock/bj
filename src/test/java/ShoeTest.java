import bj.Card;
import bj.Hand;
import bj.Shoe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoeTest {

    @Test
    public void test1DeckShuffle(){

        Shoe shoe = new Shoe(1);
        shoe.getCardIterator().forEachRemaining(System.out::println);
    }
    @Test
    public void testCardEquality(){
        Hand hand = new Hand(0);
        hand.addCard(Card.ACE);
        hand.addCard(Card.TEN);

        assertTrue(hand.getCards().indexOf(Card.ACE) == 0);
    }
    @Test
    public void whatever(){
        Shoe shoe = new Shoe(6);
    }
}

