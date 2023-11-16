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

        outputView.printBeforeDiscountPrice(order.totalPrice());

        outputView.printGiveaway(order.giveaway());

        discountList(order, date, plannerService);

        benefitResult(plannerService);
    }

    private void discountList(Order order, Date date, PlannerService plannerService){
        outputView.printDiscountIntro();
        if(!order.getDiscountState() || plannerService.totalDiscount() == 0){
            outputView.printNotting();
        }

        if(order.getDiscountState()){
            outputView.printDDayDiscount(date.dDayDiscount());
            outputView.printWeekdayDiscount(plannerService.weekdayDiscount());
            outputView.printWeekendDiscount(plannerService.weekendDiscount());
            outputView.printSpecialDiscount(date.specialDay());
            outputView.printGiveawayDiscount(order.giveaway());
        }
    }

    private void benefitResult(PlannerService plannerService){
        outputView.printTotalDiscount(plannerService.totalDiscount());
        outputView.printAfterDiscountPrice(plannerService.afterDiscountPrice());
        outputView.printBadge(plannerService.findBadge());
    }
}
