package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DateTest {

    @DisplayName("날짜가 31일을 넘어가면 예외가 발생한다.")
    @Test
    void createDateOverRange(){
        assertThatThrownBy(() -> new Date(32))
                .isInstanceOf(IllegalArgumentException.class);
    }
}