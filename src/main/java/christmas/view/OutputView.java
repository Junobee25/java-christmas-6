package christmas.view;

import christmas.util.Utils;

import java.util.Map;

public class OutputView {
    private static final String PREVIEW_BENEFIT = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_PRINT = "<주문 메뉴>";
    private static final String ORDER_MENU = "%s %d개";
    private static final String ORDER_PRICE_BEFORE_DISCOUNT_PRINT = "<할인 전 총주문 금액>";
    private static final String ORDER_PRICE_BEFORE_DISCOUNT = "%s원";

    public static void previewBenefit(int date) {
        System.out.printf(PREVIEW_BENEFIT, date);
    }

    public static void orderMenu(Map<String, Integer> order) {
        System.out.println(ORDER_PRINT);
        for (Map.Entry menu : order.entrySet()) {
            System.out.printf(ORDER_MENU, menu.getKey(), menu.getValue());
        }
    }

    public static void previewOrderPriceBeforeDiscount(int totalPrice) {
        System.out.println(ORDER_PRICE_BEFORE_DISCOUNT_PRINT);
        System.out.printf(ORDER_PRICE_BEFORE_DISCOUNT, Utils.formatPriceToWonType(totalPrice));
    }

}
