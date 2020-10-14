import org.junit.jupiter.api.Test;

public class ShoeTest {

    @Test
    public void test1DeckShuffle(){

        Shoe shoe = new Shoe(1);
        shoe.getCards().forEachRemaining(System.out::println);
    }
}

