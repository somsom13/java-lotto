package lotto.view;

import java.util.List;

public class OutputView {
    public OutputView() {
    }

    public void printIssuedLotto(List<List<Integer>> lotto) {
        System.out.printf((ViewConstant.PURCHASE_COUNT) + "\n", lotto.size());
        lotto.forEach(System.out::println);
    }
}
