package bj;

public class Rules {
    public static int DEFAULT_SHOE_SIZE = 6;
    private int shoeSize;

    public Rules() {

        this.shoeSize = DEFAULT_SHOE_SIZE;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int numOfDecks) {
        this.shoeSize = numOfDecks;
    }

    public Rules(int shoeSize) {
        this.shoeSize = shoeSize;
    }

}
