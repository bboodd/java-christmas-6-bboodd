package christmas.util;

import java.util.Arrays;

public enum Week {
    MONDAY("평일", 4),
    TUESDAY("평일", 5),
    WEDNESDAY("평일", 6),
    THURSDAY("평일", 0),
    FRIDAY("주말", 1),
    SATURDAY("주말", 2),
    SUNDAY("평일", 3);

    private final String week;
    private final int dividedNumber;

    Week(String week, int dividedNumber){
        this.week = week;
        this.dividedNumber = dividedNumber;
    }

    public String getWeek(){
        return week;
    }

    public int getDividedNumber(){
        return dividedNumber;
    }

    public static Week valueOfDividedNumber(int dividedNumber){
        return Arrays.stream(values())
                .filter(value -> value.dividedNumber == dividedNumber)
                .findAny()
                .orElse(null);
    }
}
