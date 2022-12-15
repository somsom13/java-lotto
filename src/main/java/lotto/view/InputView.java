package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.error.ExceptionString;

public class InputView {
    private final String LOTTO_REGEX = "^[0-9,]+$";

    public InputView() {
    }

    public int requestMoneyInput() {
        return readSingleNumber(Console.readLine());
    }

    public String requestWinningLotto() {
        System.out.println(ViewConstant.WINNING_REQUEST);
        return readNumbersWithComma(Console.readLine());
    }

    public int requestBonusNumber() {
        System.out.println(ViewConstant.BONUS_REQUEST);
        return readSingleNumber(Console.readLine());
    }

    private int readSingleNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException notNumberException) {
            throw new IllegalArgumentException(ExceptionString.ONLY_NUMBER.print());
        }
    }

    private String readNumbersWithComma(String input) {
        if (Pattern.matches(LOTTO_REGEX, input)) {
            return input;
        }
        throw new IllegalArgumentException(
                String.format(ExceptionString.ONLY_COMMA.print(), ViewConstant.LOTTO_DELIMITER));
    }

}
