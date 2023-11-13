package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.PlannerService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start(){
        outputView.printIntro();
        Date date = inputView.readDate();
        Order order = inputView.readOrder();
        benefit(order, date);
    }

    private void benefit(Order order, Date date){
        PlannerService plannerService = new PlannerService(order, date);
        outputView.printBenefitIntro();
        outputView.printOrder(order);
        outputView.printTotalPrice(order.totalPrice());
        outputView.printGiveaway(order.giveaway());

        outputView.printDiscountIntro();
        outputView.printDDayDiscount(date.dDayDiscount());
    }
}
