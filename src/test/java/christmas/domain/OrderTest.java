package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @DisplayName("총 주문 메뉴의 개수가 20개가 넘어가면 예외가 발생한다.")
    @Test
    void createOrderByOverQuantityMenu(){
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("크리스마스파스타", 11));
        menus.add(new Menu("제로콜라", 11));
        assertThatThrownBy(() -> new Order(menus))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("메뉴에 중복이 있으면 예외가 발생한다.")
    @Test
    void createOrderByDuplicatedMenu(){
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("크리스마스파스타", 2));
        menus.add(new Menu("크리스마스파스타", 4));

        assertThatThrownBy(() -> new Order(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료수만 주문한다면 예외가 발생한다.")
    @Test
    void createOrderByOnlyDrinkMenu(){
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("제로콜라", 2));
        menus.add(new Menu("샴페인", 1));

        assertThatThrownBy(() -> new Order(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 주문금액을 반환후 기댓값과 일치한다면 통과한다.")
    @Test
    void createTotalPrice(){
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("티본스테이크", 2));
        Order order = new Order(menus);
        int expect = 110000;

        assertEquals(order.totalPrice(), expect);
    }

    @DisplayName("증정이벤트의 금액을 반환 후 기댓값과 일치한다면 통과한다.")
    @Test
    void createGiveaway(){
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("티본스테이크", 3));
        Order order = new Order(menus);
        int expect = 25000;

        assertEquals(order.giveaway(), expect);
    }

}