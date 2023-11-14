package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidateTest {

    @DisplayName("입력이 빈칸이면 예외가 발생한다.")
    @Test
    void inputBlank(){
        assertThatThrownBy(() -> new InputValidate().validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputDateByNotDigit(){
        assertThatThrownBy(() -> new InputValidate().validateDateIsDigit("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 수량 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputMenuQuantityByNotDigit(){
        assertThatThrownBy(() -> new InputValidate().validateMenuQuantityIsDigit("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 입력이 '-'으로 구분되지 않으면 예외가 발생한다.")
    @Test
    void inputMenuByNotHyphen(){
        assertThatThrownBy(() -> new InputValidate().validateMenuInputSize("크리스마스파스타 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}