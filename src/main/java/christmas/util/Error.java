package christmas.util;

public enum Error {
    DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_QUENTITY_ERROR("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요."),
    MENU_DRINK_ERROR("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String message(){
        return message;
    }
}
