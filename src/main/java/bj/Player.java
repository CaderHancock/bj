package bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player {

    private List<Hand> hand;
    private final Integer bankroll;
    public final Integer bet = 1;
    private Set<HandActions> availableActions;

    public Player(Integer bankroll) {

        hand = new ArrayList<>();
        this.bankroll = bankroll;
    }

    private Set<HandActions> getAvailableActions() {

        return availableActions;
    }

    public List<Hand> getHand() {
        return hand;
    }

    public void setHand(List<Hand> hand) {
        this.hand = hand;
    }

    public void setAvailableActions(Set<HandActions> availableActions) {
        this.availableActions = availableActions;
    }

}
