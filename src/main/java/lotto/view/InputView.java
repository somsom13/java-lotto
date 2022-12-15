package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.ExceptionString;

public class InputView {
    public InputView() {
    }

    public int requestMoneyInput() {
        return readSingleNumber(Console.readLine());
    }

    private int readSingleNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException notNumberException) {
            throw new IllegalArgumentException(ExceptionString.ONLY_NUMBER.print());
        }
    }

}
