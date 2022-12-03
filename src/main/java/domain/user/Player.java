package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private double gameMoney;
    private boolean gameContinueFlag = true;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

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

    public int getAceLocation() {
        int aceLocation = -1;
        for (int idx = 0; idx < cards.size(); idx++) {
            if (cards.get(idx).ifAce()) {
                aceLocation =  idx;
                return aceLocation;
            }
        }
        return aceLocation;
    }

    public boolean ifContinue(String answer) {
        validateAnswer(answer);
        if (answer.equals("y")) {
            gameContinueFlag = true;
        }
        if (answer.equals("n")) {
            gameContinueFlag = false;
        }
        return gameContinueFlag;
    }

    private void validateAnswer(String answer) {
        if (!answer.equals("Y") && !answer.equals("n")) {
            throw new IllegalArgumentException("y와 n만 입력할 수 있습니다.");
        }
    }

    public boolean ifScoreOver21() {
        return getScore() > 21;
    }

    public boolean ifContinue() {
        return gameContinueFlag;
    }

    public double getBettingMoney() {
        return bettingMoney;
    }

    public void gameDone() {
        gameContinueFlag = false;
    }

    public void getOneHalfBettingMoney() {
        if (!gameContinueFlag) {
            gameMoney += bettingMoney * 0.5;
        }
    }

    public void getDoubleBettingMoney() {
        gameMoney += bettingMoney * 1;
    }

    public double getGameMoney() {
        return gameMoney;
    }

    public void lose() {
        gameMoney = 0 - bettingMoney;
    }

    public void tie() {
        gameMoney = 0;
    }
}
