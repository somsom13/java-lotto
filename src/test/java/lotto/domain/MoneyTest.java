package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    private final String ERROR = "[ERROR]";

    @DisplayName("1000원 이하의 금액이 입력되면 예외가 발생한다.")
    @Test
    void createInputWithLessThanAmount() {
        int money = 0;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액은 예외가 발생한다.")
    @Test
    void createInputWithLeftOver() {
        int money = 1500;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR);
    }

    @DisplayName("올바른 금액이 입력되면 객체가 생성된다.")
    @Test
    void createMoneySuccess() {
        int money = 5000;

        new Money(money);

        //then: test pass
    }
}