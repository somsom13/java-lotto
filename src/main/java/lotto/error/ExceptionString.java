package lotto.error;

public enum ExceptionString {
    HEAD("[ERROR] "),
    MONEY_LEFT_OVER("잔돈이 발생하였습니다."),
    NOT_ENOUGH_MONEY("%d원 이상 구매해야 합니다."),
    ONLY_NUMBER("숫자만 입력할 수 있습니다."),
    NOT_IN_RANGE("%d 부터 %d 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("로또 번호에 중복되는 숫자가 있습니다."),
    WRONG_COUNT("로또 개수는 %d개 여야 합니다."),
    ONLY_COMMA("%s와 숫자만 포함되어야 합니다.");

    private final String message;

    ExceptionString(String message) {
        this.message = message;
    }

    public String print() {
        return HEAD.message + this.message;
    }
}
