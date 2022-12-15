package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private final String ERROR = "[ERROR]";

    @DisplayName("보너스 번호가 범위 외의 숫자면 예외가 발생한다")
    @Test
    void createBonusOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다")
    @Test
    void createBonusDuplicate() {
        assertThatThrownBy(() -> new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("보너스 번호가 정상이라면 객체가 생성된다")
    @Test
    void createRightWinningLotto() {
        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);

        //then: test pass
    }

}