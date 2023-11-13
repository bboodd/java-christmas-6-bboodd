package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MenuListTest {

    @DisplayName("상품 이름이 메뉴에 있는 상품이면 통과한다.")
    @Test
    void valueOfNameTest() {
        String name = "크리스마스파스타";
        MenuList christmasPasta = MenuList.valueOfName(name);
        assertEquals(christmasPasta.getName(), name);
    }
}