package christmas.service;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.util.Discount;

public class PlannerService {
    private final Date date;
    private final Order order;

    public PlannerService(Order order, Date date){
        this.date = date;
        this.order = order;
    }

    public int weekdayDiscount(){
        int discount = 0;
        String week = date.getWeek();

        if(week.equals("평일")){
            discount = order.countDesert() * Discount.WEEK_DISCOUNT.getMoney();
        }

        return discount;
    }

    public int weekendDiscount(){
        int discount = 0;
        String week = date.getWeek();

        if(week.equals("주말")){
            discount = order.countMain() * Discount.WEEK_DISCOUNT.getMoney();
        }

        return discount;
    }

    public int totalDiscount(){
        int total = 0;
        total = date.dDayDiscount() +
                weekdayDiscount() +
                weekendDiscount() +
                order.giveaway() +
                date.specialDay();
        return total;
    }

    public int afterDiscountPrice(){
        return order.totalPrice() - totalDiscount();
    }

    public String findBadge(){
        int benefit = totalDiscount();
        if(benefit >= 20000) return "산타";
        if(benefit >= 10000) return "트리";
        if(benefit >= 5000) return "별";
        return "없음";
    }
}
