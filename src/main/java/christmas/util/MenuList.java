package christmas.util;

import java.util.Arrays;

public enum MenuList {
    //에피타이저
    MUSHROOM_SOUP("양송이수프", 6000, "에피타이저"),
    TAPAS("타파스", 5500, "에피타이저"),
    CAESAR_SALAD("시저샐러드", 8000, "에피타이저"),

    //<메인>
    T_BONE_STEAK("티본스테이크", 55000, "메인"),
    BARBECUE_RIBS("바비큐립", 54000, "메인"),
    SEAFOOD_PASTA("해산물파스타", 35000, "메인"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "메인"),

    //<디저트>
    CHOCOLATE_CAKE("초코케이크", 15000, "디저트"),
    ICE_CREAM("아이스크림", 5000, "디저트"),

    //<음료>
    ZERO_COKE("제로콜라", 3000, "음료"),
    RED_WINE("레드와인", 60000, "음료"),
    CHAMPAGNE("샴페인", 25000, "음료");

    private final String name;
    private final int price;
    private final String category;

    MenuList(String name, int price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static MenuList valueOfName(String name){
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findAny()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getCategory() {
        return category;
    }
}
