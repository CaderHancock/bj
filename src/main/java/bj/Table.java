package bj;

import java.util.List;

public class Table{

	private final int shoeSize = 6;
	private Shoe shoe;
	List<Player> players;
	private boolean cutCardSeen;
	private Dealer dealer;

	public Table(List<Player> players){
		this.players =	players;
		shoe = new Shoe(shoeSize);
		dealer = new Dealer(this.players, shoe);
	}

}
