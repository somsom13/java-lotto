package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.error.ExceptionString;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers.size());
        validateInRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public boolean isBonusInLotto(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getSortedLottoNumbers() {
        return Collections.unmodifiableList(sortNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isNumberMatch(int numberToCompare) {
        return numbers.contains(numberToCompare);
    }

    private void validateCount(int size) {
        if (size != LottoCondition.COUNT.getValue()) {
            throw new IllegalArgumentException(
                    String.format(ExceptionString.WRONG_COUNT.print(), LottoCondition.COUNT.getValue()));
        }
    }

    private void validateInRange(List<Integer> numbers) {
        if (isAllInRange(numbers)) {
            return;
        }
        throw new IllegalArgumentException(String.format(ExceptionString.NOT_IN_RANGE.print(),
                LottoCondition.MIN.getValue(), LottoCondition.MAX.getValue()));
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicateNumberExist(numbers)) {
            throw new IllegalArgumentException(ExceptionString.DUPLICATE_NUMBER.print());
        }
    }

    private boolean isAllInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isInRange);
    }

    private boolean isInRange(int number) {
        return number >= LottoCondition.MIN.getValue() && number <= LottoCondition.MAX.getValue();
    }

    private boolean isDuplicateNumberExist(List<Integer> numbers) {
        long notDuplicatedCount = numbers.stream()
                .distinct()
                .count();
        return notDuplicatedCount != LottoCondition.COUNT.getValue();
    }

    private List<Integer> sortNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
