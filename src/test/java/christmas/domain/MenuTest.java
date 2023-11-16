package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @DisplayName("메뉴판에 존재하지 않는 메뉴라면 예외가 발생한다.")
    @Test
    void createMenuByNonExistent(){
        assertThatThrownBy(() -> new Menu("크리스마스스테이크", 1))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("개수가 0이라면 예외가 발생한다.")
    @Test
    void createMenuByZeroQuantity(){
        assertThatThrownBy(() -> new Menu("크리스마스파스타", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}