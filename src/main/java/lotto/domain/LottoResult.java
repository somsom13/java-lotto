package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    Map<Prize, Integer> prizeWithCount;

    public LottoResult(List<Prize> prizes) {
        this.prizeWithCount = new EnumMap<>(Prize.class);
        initializePrize();
        mapSamePrize(prizes);
    }

    public double calculateRateOfReturn(int purchaseMoney) {
        return (double) calculateTotalAward() / (double) purchaseMoney * 100;
    }

    public Map<Prize, Integer> getResult() {
        return Collections.unmodifiableMap(prizeWithCount);
    }
    private long calculateTotalAward() {
        return Prize.calculateTotalPrize(prizeWithCount);
    }

    private void mapSamePrize(List<Prize> prizes) {
        prizes.stream()
                .filter(prize -> prize != Prize.NONE)
                .forEach(this::updatePrizeCountInMap);
    }

    private void updatePrizeCountInMap(Prize prize) {
        int count = prizeWithCount.get(prize) + 1;
        this.prizeWithCount.put(prize, count);
    }

    private void initializePrize() {
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> this.prizeWithCount.put(prize, 0));
    }
}
