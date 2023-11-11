package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidateTest {

    @DisplayName("날짜 입력이 빈칸이면 예외가 발생한다.")
    @Test
    void inputDateBlank(){
        assertThatThrownBy(() -> new InputValidate().validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputDateNotDigit(){
        assertThatThrownBy(() -> new InputValidate().validateIsDigit("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}