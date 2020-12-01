package bj;

import java.util.List;
import java.util.stream.Collectors;

public class Dealer {

    private final List<Player> players;
    private Shoe shoe;
    private boolean cutCardSeen;
    private Hand dealerHand;
    private Rules rules;

    public Dealer(List<Player> players) {

        this.players = players;
        this.rules = new Rules();
        this.shoe = new Shoe(rules.getShoeSize());
    }

    public Dealer(List<Player> players, Rules rules) {

        this.players = players;
        this.rules = rules;
        this.shoe = new Shoe(rules.getShoeSize());
    }

    public void playRound() {
        if (!cutCardSeen) {
            try {
                dealHands();
            } catch (Throwable e) {
                cutCardSeen = true;
            } finally {
                initiatePlayerAction();
            }
        } else {
            this.shoe = new Shoe(rules.getShoeSize());
            cutCardSeen = false;
            System.out.println("New shoe Remaining cards:");

            throw new RuntimeException("New Shoe. ");
            // playRound();
        }
    }

    private void initiatePlayerAction() {
    }

    private void dealHands() {

        List<Player> bettingPlayers = this.players.stream().filter(player -> player.bet > 0)
                .collect(Collectors.toList());
        bettingPlayers.forEach(player -> player.setHand(List.of(new Hand(player.bet))));
        dealerHand = new Hand(0);
        bettingPlayers.forEach(player -> player.getHand().forEach(hand -> hand.addCard(dealCard())));
        dealerHand.addCard(dealCard());
        bettingPlayers.forEach(player -> player.getHand().forEach(hand -> hand.addCard(dealCard())));
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
