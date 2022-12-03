package domain.user;

import domain.card.Card;
import domain.card.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현

    public void generateDeck() {
        Deck deck = new Deck();
        for (Card card : deck.getDeck()) {
            addCard(card);
        }
    }


}
