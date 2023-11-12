package christmas.domain;

import christmas.util.Error;

public class Date {
    private final int date;

    public Date(int date){
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date){
        if(date<1 || date>31){
            throw new IllegalArgumentException(Error.DATE_ERROR.message());
        }
    }

    //boolean? int? 타입 디데이, 평일, 주말, 특별 날짜 체크 함수
}
