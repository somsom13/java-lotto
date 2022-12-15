package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoGame = new LottoGame();
    }

    public void start() {
        issueUserBoughtLotto(inputView.requestMoneyInput());
        createWinningLotto(inputView.requestWinningLotto());
    }

    private void issueUserBoughtLotto(int money) {
        lottoGame.issueUserAutoLotto(money);
        outputView.printIssuedLotto(lottoGame.showAllLotto());
    }

    private void createWinningLotto(String winningNumbers) {
        lottoGame.setWinningLotto(transferWinningLottoNumbers(winningNumbers), inputView.requestBonusNumber());
    }

    private List<Integer> transferWinningLottoNumbers(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(numbers, ",");
        while (tokenizer.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(tokenizer.nextToken()));
        }
        return winningNumbers;
    }
}
