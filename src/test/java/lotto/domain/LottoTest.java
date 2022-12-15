package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    private final String ERROR = "[ERROR]";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("로또 번호에 중복이 있으면 예외가 발생한다")
    @Test
    void createLottoByWrongSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있음을 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"10:false", "1:true"}, delimiter = ':')
    void checkIfBonusInLotto(int bonus, boolean isContained) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isBonusInLotto(bonus)).isEqualTo(isContained);
    }
}
