package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Prize;
import lotto.dto.PrizeToReceive;

public class OutputView {
    public OutputView() {
    }

    public void printIssuedLotto(List<List<Integer>> lotto) {
        System.out.printf((ViewConstant.PURCHASE_COUNT) + "\n", lotto.size());
        lotto.forEach(System.out::println);
    }

    public void printPrizeToReceive(PrizeToReceive prize) {
        System.out.println(ViewConstant.RESULT_HEAD);
        printPrizeDetail(prize.getPrizeWithCount());
        printRateOfReturn(prize.getRateOfReturn());
    }

    private void printPrizeDetail(Map<Prize, Integer> prizeInfo) {
        prizeInfo.forEach((key, value) ->
                System.out.println(transferToPrizeString(key) + transferToMatchString(value)));
    }

    private void printRateOfReturn(double rate) {
        System.out.printf(ViewConstant.FINAL_RATE, String.format(ViewConstant.RATE_OF_RETURN, rate));
    }

    private String transferToPrizeString(Prize prize) {
        return String.format(ViewConstant.MATCH_RESULT,
                prize.getMatchCount(), selectBonusString(prize.isHasBonus()), transferMoneyForm(prize.getAward()));
    }

    private String transferToMatchString(int count) {
        return String.format(ViewConstant.MATCH_COUNT, count);
    }

    private String selectBonusString(boolean hasBonus) {
        if (hasBonus) {
            return ViewConstant.BONUS_INCLUDE;
        }
        return ViewConstant.EMPTY_STRING;
    }

    private String transferMoneyForm(long money) {
        return ViewConstant.MONEY_FORMAT.format(money);
    }
}
