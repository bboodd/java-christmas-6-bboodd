package christmas.util;

public enum Discount {
    CHAMPAGNE_GIVEAWAY(120000),
    MIN_DISCOUNT(10000),
    D_DAY_DEFAULT_DISCOUNT(1000),
    D_DAY_EXTRA_DISCOUNT(100),
    WEEK_DISCOUNT(2023),
    SPECIAL_DISCOUNT(1000);

    private final int money;

    Discount(int money) {
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
