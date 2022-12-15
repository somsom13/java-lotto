package lotto.domain;

import java.util.List;
import lotto.error.ExceptionString;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validateBonusInRange(bonus);
        validateDuplicateWithLotto(bonus);
        this.bonus = bonus;
    }

    public int calculateMatchLottoCount(List<Integer> purchasedLotto) {
        return (int) purchasedLotto.stream()
                .filter(lotto::isNumberMatch)
                .count();
    }

    public boolean isBonusMatch(List<Integer> purchasedLotto) {
        return purchasedLotto.contains(bonus);
    }

    private void validateBonusInRange(int bonus) {
        if (bonus <= LottoCondition.MAX.getValue() && bonus >= LottoCondition.MIN.getValue()) {
            return;
        }
        throw new IllegalArgumentException(String.format(ExceptionString.NOT_IN_RANGE.print(),
                LottoCondition.MIN.getValue(), LottoCondition.MAX.getValue()));
    }

    private void validateDuplicateWithLotto(int bonus) {
        if (lotto.isBonusInLotto(bonus)) {
            throw new IllegalArgumentException(ExceptionString.DUPLICATE_NUMBER.print());
        }
    }
}
