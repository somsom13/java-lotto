package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.AutoLottoGenerator;
import lotto.dto.PrizeToReceive;

public class LottoGame {
    private Money money;
    private List<Lotto> purchasedLotto;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

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

    public void calculateLottoResult() {
        lottoResult = new LottoResult(purchasedLotto.stream()
                .map(lotto -> transferToPrize(lotto.getLottoNumbers()))
                .collect(Collectors.toList()));
    }

    public PrizeToReceive getPrizeInfo() {
        return PrizeToReceive.of(lottoResult, money.getPurchasedMoney());
    }

    private Prize transferToPrize(List<Integer> purchasedLotto) {
        return Prize.calculatePrizeToReceive(winningLotto.calculateMatchLottoCount(purchasedLotto),
                winningLotto.isBonusMatch(purchasedLotto));
    }

    private List<Lotto> issueAutoLotto() {
        return AutoLottoGenerator.issuePurchasedAutoLotto(money.calculatePurchaseCount())
                .stream()
                .map(Lotto::new)
                .collect(Collectors.toList()); //근데 이게 변경 불가해야 하면 그냥 list 객체를 하나 또 만드는게 나을지도
    }
}
