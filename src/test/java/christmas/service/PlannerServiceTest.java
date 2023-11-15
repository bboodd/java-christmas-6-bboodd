package christmas.service;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlannerServiceTest {

    @DisplayName("평일이라면 디저트의 개수당 2023원을 곱한 값을 반환 후 기댓값과 일치하면 통과한다.")
    @Test
    void weekdayDiscount() {
        List<Menu> menus = new ArrayList<>();

        Date date = new Date(13);
        menus.add(new Menu("초코케이크", 2));
        Order order = new Order(menus);

        PlannerService plannerService = new PlannerService(order, date);

        int expect = 4046;

        assertEquals(plannerService.weekdayDiscount(), expect);


    }

    @DisplayName("주말이라면 메인메뉴의 개수당 2023원을 곱한 값을 반환 후 기댓값과 일치하면 통과한다.")
    @Test
    void weekendDiscount() {
        List<Menu> menus = new ArrayList<>();

        Date date = new Date(9);
        menus.add(new Menu("크리스마스파스타", 2));
        Order order = new Order(menus);

        PlannerService plannerService = new PlannerService(order, date);

        int expect = 4046;

        assertEquals(plannerService.weekendDiscount(), expect);
    }

    @DisplayName("총 할인 가격을 반환 후 기댓값과 일치하면 통과한다.")
    @Test
    void totalDiscount() {
        List<Menu> menus = new ArrayList<>();

        Date date = new Date(25);
        menus.add(new Menu("크리스마스파스타", 2));
        menus.add(new Menu("아이스크림", 2));
        Order order = new Order(menus);

        PlannerService plannerService = new PlannerService(order, date);

        int expect = 8446;

        assertEquals(plannerService.totalDiscount(), expect);
    }

    @DisplayName("총 메뉴 가격에 총 할인가격을 뺀 값을 반환 후 기댓값과 일치하면 통과한다.")
    @Test
    void afterDiscountPrice() {
        List<Menu> menus = new ArrayList<>();

        Date date = new Date(25);
        menus.add(new Menu("크리스마스파스타", 2));
        menus.add(new Menu("아이스크림", 2));
        Order order = new Order(menus);

        PlannerService plannerService = new PlannerService(order, date);

        int expect = 51554;

        assertEquals(plannerService.afterDiscountPrice(), expect);
    }

    @DisplayName("총 할인 가격에 해당하는 뱃지를 반환 후 기댓값과 일치하면 통과한다.")
    @Test
    void findBadge() {
        List<Menu> menus = new ArrayList<>();

        Date date = new Date(25);
        menus.add(new Menu("크리스마스파스타", 2));
        menus.add(new Menu("아이스크림", 2));
        Order order = new Order(menus);

        PlannerService plannerService = new PlannerService(order, date);

        String expect = "별";

        assertEquals(plannerService.findBadge(), expect);
    }
}