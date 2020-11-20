package bj;

import bj.ap.CountStrategy;
import bj.ap.Counter;

import java.util.List;
import java.util.function.Function;

public class Dealer{

    private Counter counter;
    private final List<Player> players;
    private final Shoe shoe;
    private boolean cutCardSeen;
    private Hand dealerHand;

    public Dealer(List<Player> players, Shoe shoe) {

        this.players = players;
        this.shoe = shoe;
    }
    public Dealer(List<Player> players, Shoe shoe,
                  CountStrategy countStrategy, Rules rules) {

        this.players = players;
        this.shoe = shoe;
        this.counter = new Counter(countStrategy, rules.getNumOfDecks());
    }
    public void playRound(){

        if(!cutCardSeen){
            dealHands();
            players.stream().map(x -> 
                this.setAvailableActions(x)).toArray();
        }
    }
    private Player setAvailableActions(Player player){

        return player;
    }
/*
 * This is shitty and a side effect/code smell
 * But card dealing happens in a certain order so fuck it.
 */
    private void dealHands() {

        for (int i = 0; i < players.size() ; i++) {

        }

        players.forEach(player ->
            player.setHand(List.of(new Hand(player.bet))));
        dealerHand = new Hand(0);
        players.forEach(player ->
            player.getHand()
                .forEach(hand ->
                    hand.addCard(dealCard())));
        dealerHand.addCard(dealCard());
        players.forEach(player ->
            player.getHand()
                .forEach(hand ->
                    hand.addCard(dealCard())));
        dealerHand.addCard(dealCard());
    }



    private Card dealCard()  {

        Card card = shoe.next();
        if(card == Card.CUTCARD) {
            cutCardSeen = true;
            card = shoe.next();
//            if (counter != null)
//            return card;
        }
        return card;
    }

    public void playPlayer(Player player){

    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(Hand dealerHand) {
        this.dealerHand = dealerHand;
    }

}
