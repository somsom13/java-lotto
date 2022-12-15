package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoCondition;

public class AutoLottoGenerator {
    private AutoLottoGenerator() {
    }

    public static List<List<Integer>> issuePurchasedAutoLotto(int purchaseCount) {
        List<List<Integer>> allLottos = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count++) {
            allLottos.add(generateAutoLotto());
        }
        return allLottos;
    }

    private static List<Integer> generateAutoLotto() {
        return Randoms.pickUniqueNumbersInRange(LottoCondition.MIN.getValue(), LottoCondition.MAX.getValue(),
                LottoCondition.COUNT.getValue());
    }
}
