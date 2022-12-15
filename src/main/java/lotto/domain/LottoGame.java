package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.AutoLottoGenerator;

public class LottoGame {
    private final Money money;
    private final List<Lotto> purchasedLotto;

    public LottoGame(int money) {
        this.money = new Money(money);
        purchasedLotto = issueAutoLotto();
    }

    private List<Lotto> issueAutoLotto() {
        return AutoLottoGenerator.issuePurchasedAutoLotto(money.calculatePurchaseCount())
                .stream()
                .map(Lotto::new)
                .collect(Collectors.toList()); //근데 이게 변경 불가해야 하면 그냥 list 객체를 하나 또 만드는게 나을지도
    }
}
