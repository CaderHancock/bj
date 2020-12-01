package bj.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import bj.Card;
import bj.Shoe;

public class ShoeTest {

    @Test
    public void cutCardAlwaysThere() {

        for (int i = 0; i < 1000; i++) {
            Shoe shoe = new Shoe(6);
            assertTrue(Stream.generate(() -> null).takeWhile(x -> shoe.getCardIterator().hasNext())
                    .map(n -> shoe.getCardIterator().next()).anyMatch(x -> x.equals(Card.CUTCARD)));
        }
    }
}
