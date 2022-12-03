package domain.card;

import java.util.Collections;
import java.util.List;

public class Deck {

    public static List<Card> deck;

    public Deck() {
        CardFactory.create();
        Collections.shuffle(deck);
    }

    public static Card getCard() {
        return deck.subList(0, 1).get(0);
    }
}
