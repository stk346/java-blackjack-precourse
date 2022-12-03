package domain.user;

import domain.card.Card;
import domain.card.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

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

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getScore();
        }
        return score;
    }

    public int getConvertedAceScore() {
        int score = getScore();
        if (getAceLocation() >= 0) {
            cards.get(getAceLocation()).convertAce();
            score = getScore();
        }
        return score;
    }

    private int getAceLocation() {
        int aceLocation = -1;
        for (int idx = 0; idx < cards.size(); idx++) {
            if (cards.get(idx).ifAce()) {
                aceLocation =  idx;
                return aceLocation;
            }
        }
        return aceLocation;
    }



    public boolean ifScoreOver21() {
        return getScore() > 21;
    }

    public double getLostMoney() {
        return bettingMoney;
    }

    public double getLostTheBettingMoney() {
        return 0 - bettingMoney;
    }
}
