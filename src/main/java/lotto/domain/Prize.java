package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Prize {
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false),
    NONE(0, 0, false);

    private static final Map<Integer, Prize> MATCH_COUNT_PRIZE_MAP = Arrays.stream(values())
            .filter(prize -> !prize.hasBonus)
            .collect(Collectors.toMap(Prize::getMatchCount, prize -> prize));
    private final int matchCount;
    private final int award;
    private final boolean hasBonus;

    Prize(int matchCount, int award, boolean hasBonus) {
        this.matchCount = matchCount;
        this.award = award;
        this.hasBonus = hasBonus;
    }

    public static Prize calculatePrizeToReceive(int matchCount, boolean hasBonus) {
        if (isBonusMatch(matchCount, hasBonus)) {
            return BONUS;
        }
        return MATCH_COUNT_PRIZE_MAP.getOrDefault(matchCount, NONE);
    }

    public static long calculateTotalPrize(Map<Prize, Integer> prizeWithCount) {
        return prizeWithCount.entrySet()
                .stream()
                .map(set -> set.getKey().calculateTotalAwardForEachPrize(set.getValue()))
                .mapToLong(Long::longValue)
                .sum();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAward() {
        return award;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    private static boolean isBonusMatch(int matchCount, boolean hasBonus) {
        return matchCount == BONUS.matchCount && hasBonus;
    }

    private long calculateTotalAwardForEachPrize(int count) {
        return (long) this.award * count;
    }
}
