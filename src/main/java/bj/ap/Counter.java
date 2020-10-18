package bj.ap;

import bj.Card;

public class Counter {

    private CountStrategy countStrategy;
    private int runningCount = 0;
    private int trueCount = 0;
    private int cardsSeen;
    private int totalCards;
    private int decks;

    public Counter(CountStrategy countStrategy, int decks){
       totalCards = decks * 52;
       cardsSeen = 0;
       this.countStrategy = countStrategy;


    }
    public int getRunningCount() {

        return runningCount;
    }

    private double decksRemaining(){
        return (totalCards - cardsSeen)/52;
    }


    public double getTrueCount() {
        return ((double) runningCount)/(decksRemaining());
    }

    public void countCard(Card card) {
            runningCount += countStrategy.strategyValue(card);
    }

}
