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

        assertEquals(date.dDayDiscount(), expect);
    }
}