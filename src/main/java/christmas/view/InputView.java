package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.util.InputValidate;
import christmas.util.MenuList;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final InputValidate inputValidate = new InputValidate();
    public static Date readDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            inputValidate.validateBlank(input);
            inputValidate.validateIsDigit(input);
            Date date = new Date(Integer.parseInt(input));
            return date;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readDate();
        }
    }

    public static Menu readMenu(String input){
        inputValidate.validateMenuInputSize(input);
        String[] menu = input.split("-");
        String name = menu[0];

        String quantity = menu[1];
        inputValidate.validateBlank(quantity);
        inputValidate.validateIsDigit(quantity);
        return new Menu(name, Integer.parseInt(quantity));

    }

    public static Order readOrder(){
        try {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();
            List<Menu> order = new ArrayList<>();
            for(String inputComma : input.split(",")){
                order.add(readMenu(inputComma));
            }
            return new Order(order);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readOrder();
        }
    }
}
