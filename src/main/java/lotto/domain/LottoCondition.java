package lotto.domain;

public enum LottoCondition {
    MIN(1),
    MAX(45),
    COUNT(6);
    //여기에 돈이 있어도 될 듯?
    private final int value;

    LottoCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
