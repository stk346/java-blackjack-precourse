package domain.user;

import domain.card.Card;
import domain.card.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {

    private double gameMoney;
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현
    public List<Card> getCards() {
        return cards;
    }

    public int getConvertedAceScore(boolean convertAce) {
        int score = getScore();
        if (convertAce) {
            cards.get(getAceLocation()).convertAce();
            score = getScore();
        }
        return score;
    }

    private int getScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getScore();
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

    public boolean ifScoreOver22() {
        return getScore() >= 22;
    }

    public boolean ifScoreUnder17() {
        return getScore() <= 16;
    }
}
