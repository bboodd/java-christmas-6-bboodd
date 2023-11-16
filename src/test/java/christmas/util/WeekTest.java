package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WeekTest {

    @DisplayName("나눈 숫자가 해당 요일에 맞는 숫자면 통과한다")
    @Test
    void valueOfDividedNumber() {
        int mon = 4;
        Week monDay = Week.valueOfDividedNumber(mon);
        assertEquals(monDay.getDividedNumber(), mon);
    }
}