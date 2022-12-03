package domain;

import domain.user.Dealer;
import domain.user.Player;
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

    public void ifDealerBlackJack(boolean convertAce) {
        players.playerCheck(convertAce);
        for (Player player : players.getPlayers()) {
            getPlayerResultWhenDealerBlackJack(player);
        }
    }

    private void getPlayerResultWhenDealerBlackJack(Player player) {
        if (player.ifContinue()) {
            player.lose();
        }
        if (!player.ifContinue()) {
            player.tie();
        }
    }
}
