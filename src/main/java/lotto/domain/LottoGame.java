package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.AutoLottoGenerator;

public class LottoGame {
    private Money money;
    private List<Lotto> purchasedLotto;
    private WinningLotto winningLotto;

    public LottoGame() {
    }

    public void setWinningLotto(List<Integer> winningNumbers, int bonus) {
        winningLotto = new WinningLotto(new Lotto(winningNumbers), bonus);
    }

    public void issueUserAutoLotto(int money) {
        this.money = new Money(money);
        this.purchasedLotto = issueAutoLotto();
    }

    public List<List<Integer>> showAllLotto() {
        return purchasedLotto.stream()
                .map(Lotto::getSortedLottoNumbers)
                .collect(Collectors.toList());
    }

    private List<Lotto> issueAutoLotto() {
        return AutoLottoGenerator.issuePurchasedAutoLotto(money.calculatePurchaseCount())
                .stream()
                .map(Lotto::new)
                .collect(Collectors.toList()); //근데 이게 변경 불가해야 하면 그냥 list 객체를 하나 또 만드는게 나을지도
    }
}
