package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.util.InputValidate;

public class InputView {
    private final InputValidate inputValidate = new InputValidate();
    public Date readDate() {
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
}
