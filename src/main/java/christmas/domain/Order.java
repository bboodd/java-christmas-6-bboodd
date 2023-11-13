package christmas.domain;

import christmas.util.Discount;
import christmas.util.Error;
import christmas.util.MenuList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order {

    private final List<Menu> order;

    public Order(List<Menu> order){
        validateOverRange(order);
        validateDuplicateMenu(order);
        validateOnlyDrink(order);
        this.order = order;
    }

    private void validateOverRange(List<Menu> order){
        int sum = 0;

        for(Menu menu : order){
            sum += menu.getQuantity();
        }

        if(sum > 20){
            throw new IllegalArgumentException(Error.MENU_QUENTITY_ERROR.message());
        }
    }

    private void validateDuplicateMenu(List<Menu> order){
        Set<String> names = new HashSet<>();

        for(Menu menu : order){
            names.add(menu.getName());
        }

        if(order.size() != names.size()){
            throw new IllegalArgumentException(Error.MENU_ERROR.message());
        }
    }

    private void validateOnlyDrink(List<Menu> order){
        List<String> categories = new ArrayList<>();

        for(Menu menu : order){
            String category = menu.getCategory();
            if(category == "음료"){
                categories.add(category);
            }
        }

        if(order.size() == categories.size()){
            throw new IllegalArgumentException(Error.MENU_DRINK_ERROR.message());
        }
    }

    public int totalPrice(){
        int totalPrice = 0;
        for(Menu menu : order){
            totalPrice += menu.getMenuPrice();
        }
        return totalPrice;
    }

    public int giveaway(){ // 샴페인 증정 이벤트
        Discount giveaway = Discount.CHAMPAGNE_GIVEAWAY;

        if(totalPrice() >= giveaway.getMoney()){
            return MenuList.CHAMPAGNE.getPrice();
        }

        return 0;
    }

    public List<Menu> getOrder(){
        return order;
    }

}
