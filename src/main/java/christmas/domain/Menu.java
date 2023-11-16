package christmas.domain;

import christmas.util.Error;
import christmas.util.MenuList;

public class Menu {
    private final MenuList menu;
    private final int quantity;

    public Menu(String name, int quantity){
        validateIsMenu(name);
        validateRange(quantity);
        this.quantity = quantity;
        this.menu = MenuList.valueOfName(name);
    }

    private void validateIsMenu(String name){
        if(MenuList.valueOfName(name) == null){
            throw new IllegalArgumentException(Error.MENU_ERROR.message());
        }
    }

    private void validateRange(int quantity){
        if(quantity < 1){
            throw new IllegalArgumentException(Error.MENU_ERROR.message());
        }
    }

    public int getQuantity(){
        return quantity;
    }

    public String getName(){
        return menu.getName();
    }

    public int getMenuPrice(){
        return menu.getPrice() * quantity;
    }

    public String getCategory(){
        return menu.getCategory();
    }
}
