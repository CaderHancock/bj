import java.util.ArrayList;
import java.util.List;

class Player{


	private List<Hand> hand;
	private Integer bankroll;

	public Player(Integer bankroll){

		hand = new ArrayList<>();
		this.bankroll = bankroll;

	}

}
