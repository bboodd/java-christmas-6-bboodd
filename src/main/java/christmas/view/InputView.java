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
    private static final OutputView outputView = new OutputView();
    public static Date readDate() {
        try {
            outputView.printReadDate();
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
            outputView.printReadOrder();
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
