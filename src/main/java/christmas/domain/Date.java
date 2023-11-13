package christmas.domain;

import christmas.util.Discount;
import christmas.util.Error;
import christmas.util.Week;

public class Date {
    private final int date;
    private final Week week;
    private boolean specialDay = false;


    public Date(int date){
        validateRange(date);
        this.week = findWeek(date);
        this.date = date;
    }

    private Week findWeek(int date){
        int sevenDays = 7;
        int dividedNumber = date % sevenDays;
        return Week.valueOfDividedNumber(dividedNumber);
    }

    private void validateRange(int date){
        if(date<1 || date>31){
            throw new IllegalArgumentException(Error.DATE_ERROR.message());
        }
    }

    public int dDayDiscount(){
        if(date > 0  && date < 26){
            int defaultDiscount = Discount.D_DAY_DEFAULT_DISCOUNT.getMoney();
            int extraDiscount = Discount.D_DAY_EXTRA_DISCOUNT.getMoney() * (date - 1);
            return defaultDiscount + extraDiscount;
        }
        return 0;
    }

    public String getWeek(){
        return week.getWeek();
    }

    //boolean? int? 타입 디데이, 평일, 주말, 특별 날짜 체크 함수
}
