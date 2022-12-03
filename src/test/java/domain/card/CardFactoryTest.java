package domain.card;

import domain.user.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardFactoryTest {
    @Test
    void create() {
        List<Card> cards = CardFactory.create();
        assertThat(cards).hasSize(52);
        System.out.println(cards);
    }

    @Nested
    public class PlayerTest {
        Player player = new Player("pobi", 10000);

        @BeforeEach
        void setUp() {
            player.addCard(new Card(Symbol.ACE, Type.SPADE));
            player.addCard(new Card(Symbol.KING, Type.SPADE));
        }

        @Test
        void 카드_받는_기능_테스트() {
            Card testingCard = new Card(Symbol.ACE, Type.SPADE);
            assertThat(player.getCards().get(0)).isEqualTo(testingCard);
        }

        @Test
        void 카드_개수_테스트() {
            assertThat(player.getCards().size()).isEqualTo(2);
        }

        @Test
        void 점수_계산_테스트() {
            int playerScore = player.getScore();
            assertThat(playerScore).isEqualTo(11);
        }
    }
}
