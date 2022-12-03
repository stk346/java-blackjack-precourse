package domain;

import domain.user.Dealer;
import domain.user.Players;

public class BlackJackGame {

    private final Dealer dealer;
    private final Players players;
    private double totalBettingMoney;

    public BlackJackGame(Dealer dealer, Players players, double totalBettingMoney) {
        this.dealer = dealer;
        this.players = players;
        this.totalBettingMoney = players.getTotalBettingMoney();
    }


}
