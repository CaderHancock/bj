package bj;

import java.util.List;
import bj.ap.CountStrategy;

public class Dealer {

    private final List<Player> players;
    private Shoe shoe;
    private boolean cutCardSeen;
    private Hand dealerHand;

    public Dealer(List<Player> players, Shoe shoe) {

        this.players = players;
        this.shoe = shoe;
    }

    public Dealer(List<Player> players, Shoe shoe, CountStrategy countStrategy, Rules rules) {

        this.players = players;
        this.shoe = shoe;
    }

    public void playRound() {
        if (!cutCardSeen) {
            dealHands();
        }
    }

    private void dealHands() {

        players.forEach(player -> player.setHand(List.of(new Hand(player.bet))));
        dealerHand = new Hand(0);
        players.forEach(player -> player.getHand().forEach(hand -> hand.addCard(dealCard())));
        dealerHand.addCard(dealCard());
        players.forEach(player -> player.getHand().forEach(hand -> hand.addCard(dealCard())));
        dealerHand.addCard(dealCard());
    }

    private Card dealCard() {

        Card card = shoe.next();
        if (card == Card.CUTCARD) {
            cutCardSeen = true;
            card = shoe.next();
            // if (counter != null)
            // return card;
        }
        return card;
    }

    public void playPlayer(Player player) {

    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(Hand dealerHand) {
        this.dealerHand = dealerHand;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

}
