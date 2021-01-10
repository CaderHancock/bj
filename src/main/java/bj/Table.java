package bj;

import java.util.List;

public class Table {

    private final int shoeSize = 6;
    List<Player> players;
    private boolean cutCardSeen;
    private final Dealer dealer;

    public Table(List<Player> players) {
        this.players = players;
        dealer = new Dealer(this.players);
    }

    public void play() {
        while (!cutCardSeen) {
            dealer.playRound();
        }
    }
}
