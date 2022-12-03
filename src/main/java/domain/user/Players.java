package domain.user;

import java.util.List;

public class Players {

    List<Player> players;

    public Players(String names, List<Integer> bettingMoneys) {
        String[] playerNames = getPlayerNames(names);
        validateSize(playerNames, bettingMoneys);

        for (int idx = 0; idx < playerNames.length; idx++) {
            Player player = new Player(playerNames[idx], bettingMoneys.get(idx));
            players.add(player);
        }
    }

    private void validateSize(String[] playerNames, List<Integer> bettingMoneys) {
        if (playerNames.length != bettingMoneys.size()) {
            throw new IllegalArgumentException("플레이어와 베팅 금액의 개수가 맞지 않습니다.");
        }
    }

    public String[] getPlayerNames(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException("이름은 콤마 + 스페이스(\" \")로 구분해주세요.");
        }
        return names.split(", ");
    }


}
