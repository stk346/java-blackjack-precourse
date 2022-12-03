package domain.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> deck;

    public Deck() {
        deck = CardFactory.create();
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }
}
