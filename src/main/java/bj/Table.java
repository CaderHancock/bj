package bj;

import java.util.List;

public class Table{

	private final int shoeSize = 6;
	List<Player> players;
	private boolean cutCardSeen;
        private final Dealer dealer;

	public Table(List<Player> players){
		this.players =	players;
		Shoe shoe = new Shoe(shoeSize);
		dealer = new Dealer(this.players, shoe);
	}
        public void play(){
            while (!cutCardSeen) {
                dealer.playRound();
            }
        }
		public void notReal(int i) {
		}
}
