package bj.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import bj.Card;
import bj.CardUtils;
import bj.Dealer;
import bj.Hand;
import bj.Player;
import bj.Shoe;

public class DealerTest {
    Player player;
    Shoe shoe;
    Dealer dealer;

    @BeforeEach
    void setup() {
        player = new Player(1000);
        shoe = new Shoe(6);
        dealer = new Dealer(List.of(player), shoe);
    }

    @Test
    public void dealTest() {
        Player player = new Player(1000);
        Shoe shoe = new Shoe(6);
        Dealer dealer = new Dealer(List.of(player), shoe);
        dealer.playRound();
        Hand playerHand = player.getHand().get(0);
        System.out.println("bj.Player bj.Hand:" + playerHand.getCards() + ":" + CardUtils.sumHand(playerHand));
        System.out.println("bj.Dealer upcard:" + dealer.getDealerHand().getCards().get(1) + ": "
                + CardUtils.sumHand(dealer.getDealerHand()));
        for (int i = 0; i < 5; i++)
            System.out.println(shoe.next());
    }

    @Test
    @Disabled
    public void onlyPositive() {
        for (int i = 0; i < 1000; i++) {
            dealer.playRound();
            Hand playerHand = player.getHand().get(0);
            Hand dealerHand = dealer.getDealerHand();
            if (CardUtils.sumHand(playerHand) == 0 || CardUtils.sumHand(dealerHand) == 0) {

                System.out.println("FUCK" + playerHand.getCards() + "sum:" + CardUtils.sumHand(playerHand)
                        + dealerHand.getCards() + "sum:" + CardUtils.sumHand(dealerHand));
                fail();
            }
        }
    }

    @Test
    public void cutCardAlwaysThere() {

        for (int i = 0; i < 1000; i++) {
            assertTrue(Stream.generate(() -> null).takeWhile(x -> shoe.getCardIterator().hasNext())
                    .map(n -> shoe.getCardIterator().next()).anyMatch(x -> x.equals(Card.CUTCARD)));
            shoe = new Shoe(6);
        }
    }

}
