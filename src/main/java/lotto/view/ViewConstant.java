package lotto.view;

import java.text.DecimalFormat;

public class ViewConstant {
    public static final String MONEY_REQUEST = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_COUNT = "%d개를 구매했습니다.";
    public static final String WINNING_REQUEST = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_REQUEST = "보너스 번호를 입력해 주세요.";
    public static final String RESULT_HEAD = "당첨 통계\n---";
    public static final String MATCH_RESULT = "%d개 일치%s (%s원)";
    public static final String MATCH_COUNT = " - %d개";
    public static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");
    public static final String BONUS_INCLUDE = ", 보너스 볼 일치";
    public static final String EMPTY_STRING = "";
    public static final String FINAL_RATE = "총 수익률은 %s%%입니다.";
    public static final String RATE_OF_RETURN = "%.1f";
    public static final String LOTTO_DELIMITER = ",";
}
