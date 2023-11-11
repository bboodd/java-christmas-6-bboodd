package christmas;

import christmas.controller.PlannerController;

public class Application {

    private static final PlannerController plannerController = new PlannerController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        plannerController.start();
    }
}
