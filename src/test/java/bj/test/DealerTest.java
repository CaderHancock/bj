package bj.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import bj.CardUtils;
import bj.Dealer;
import bj.Hand;
import bj.Player;
import bj.Rules;
import bj.Shoe;

public class DealerTest {
    Player player;
    Shoe shoe;
    Dealer dealer;

    @BeforeEach
    void setup() {
        player = new Player(1000);
        dealer = new Dealer(List.of(player), new Rules(8));
    }

    @Disabled
    @Test
    public void dealTest() {
        Player player = new Player(1000);
        Dealer dealer = new Dealer(List.of(player));
        dealer.playRound();
        Hand playerHand = player.getHand().get(0);
        System.out.println("bj.Player bj.Hand:" + playerHand.getCards() + ":" + CardUtils.sumHand(playerHand));
        System.out.println("bj.Dealer upcard:" + dealer.getDealerHand().getCards().get(1) + ": "
                + CardUtils.sumHand(dealer.getDealerHand()));
    }

    @Test
    public void onlyPositive() {
        for (int i = 0; i < 1000; i++) {
            try {
                dealer.playRound();
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                break;
            }
            Hand playerHand = player.getHand().get(0);
            Hand dealerHand = dealer.getDealerHand();
            System.out.println("FUCK" + playerHand.getCards() + "sum:" + CardUtils.sumHand(playerHand)
                    + dealerHand.getCards() + "sum:" + CardUtils.sumHand(dealerHand));
            if (CardUtils.sumHand(playerHand) == 0 || CardUtils.sumHand(dealerHand) == 0) {
                // Oh, the tests we write when we still have no idea what is going on.
                fail();
            }
        }
    }

}
