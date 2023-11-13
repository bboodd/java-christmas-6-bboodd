package christmas.service;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.util.Discount;
import christmas.util.MenuList;

public class PlannerService {
    private boolean discountState = false;
    private final Date date;
    private final Order order;
    private int totalDiscount;

    public PlannerService(Order order, Date date){
        if(order.totalPrice() >= Discount.MIN_DISCOUNT.getMoney()){
            discountState = true;
        }
        this.date = date;
        this.order = order;
    }

    //평일할인 주말할인
}
