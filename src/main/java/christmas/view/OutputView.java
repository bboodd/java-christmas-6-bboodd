package christmas.view;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.text.DecimalFormat;

public class OutputView {
    DecimalFormat formatter = new DecimalFormat("###,###");

    public void printIntro(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printReadDate(){
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printReadOrder(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printBenefitIntro(){
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");

    }

    public void printOrder(Order order) {
        System.out.println("<주문 메뉴>");
        for(Menu menu : order.getOrder()){
            printMenu(menu);
        }
        System.out.println();
    }

    public void printMenu(Menu menu){
        System.out.println(menu.getName() + " " + menu.getQuantity() + "개");
    }

    public void printTotalPrice(int totalPrice){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%s원\n", formatter.format(totalPrice));
        System.out.println();
    }

    public void printGiveaway(int giveaway){
        System.out.println("<증정 메뉴>");
        if(giveaway == 0){
            System.out.println("없음");
        }

        if(giveaway != 0){
            System.out.println("샴페인 1개");
        }
        System.out.println();
    }

    //혜택 내역 출력
    public void printDiscountIntro(){
        System.out.println("<혜택 내역>");
    }

    public void printDDayDiscount(int dDayDiscount){
        if(dDayDiscount != 0) {
            System.out.printf("크리스마스 디데이 할인: -%s원\n", formatter.format(dDayDiscount));
        }
    }

    public void printWeekdayDiscount(int weekdayDiscount){
        System.out.printf("평일 할인: -%d원\n", formatter.format(weekdayDiscount));
    }

    public void printWeekendDiscount(int weekendDiscount){
        System.out.printf("주말 할인: -%d원\n", formatter.format(weekendDiscount));
    }

    public void printSpecialDiscount(int specialDiscount){
        System.out.printf("특별 할인: -1,000원");
    }
}
