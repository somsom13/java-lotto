package lotto.domain;

import lotto.error.ExceptionString;

public class Money {
    private static final int MIN_MONEY = 1000;
    private final int money;

    public Money(int money) {
        validateEnoughMoney(money);
        validateLeftMoney(money);
        this.money = money;
    }

    public int calculatePurchaseCount() {
        return money / MIN_MONEY;
    }

    public int getPurchasedMoney() {
        return money;
    }

    private void validateLeftMoney(int money) {
        if (isMoneyLeft(money)) {
            throw new IllegalArgumentException(ExceptionString.MONEY_LEFT_OVER.print());
        }
    }

    private void validateEnoughMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(String.format(ExceptionString.NOT_ENOUGH_MONEY.print(), MIN_MONEY));
        }
    }

    private boolean isMoneyLeft(int money) {
        return money % MIN_MONEY != 0;
    }
}
