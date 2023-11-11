package christmas.util;

public enum Error {
    DATE_RANGE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    private Error(String message) {
        this.message = message;
    }

    public String message(){
        return message;
    }
}
