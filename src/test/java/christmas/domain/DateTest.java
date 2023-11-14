package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @DisplayName("날짜가 31일을 넘어가면 예외가 발생한다.")
    @Test
    void createDateByOverRange(){
        assertThatThrownBy(() -> new Date(32))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("디데이 할인금액을 반환 후 기댓값과 일치하면 통과한다.")
    @Test
    void createDDayDiscount(){
        Date date = new Date(20);
        int expect = 2900;

        Date date2 = new Date(2);
        int expect2 = 1100;

        assertEquals(date.dDayDiscount(), expect);
        assertEquals(date2.dDayDiscount(), expect2);
    }

    @DisplayName("특별할인 금액을 반환후 기댓값과 일치하면 통과한다.")
    @Test
    void createSpecialDay(){
        Date date = new Date(24);
        int expect = 1000;

        Date date2 = new Date(26);
        int expect2 = 0;

        assertEquals(date.specialDay(), expect);
        assertEquals(date2.specialDay(), expect2);
    }
}