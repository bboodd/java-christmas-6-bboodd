package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start(){
        outputView.printIntro();
        Date date = inputView.readDate();
        Order order = inputView.readOrder();
    }
}
