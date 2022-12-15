package lotto.dto;

import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

public class PrizeToReceive {
    Map<Prize, Integer> prizeWithCount;
    double rateOfReturn;

    PrizeToReceive(Map<Prize, Integer> prize, double rateOfReturn) {
        this.prizeWithCount = prize;
        this.rateOfReturn = rateOfReturn;
    }

    public static PrizeToReceive of(LottoResult lottoResult, int purchaseMoney) {
        return new PrizeToReceive(lottoResult.getResult(), lottoResult.calculateRateOfReturn(purchaseMoney));
    }

    public Map<Prize, Integer> getPrizeWithCount() {
        return prizeWithCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
