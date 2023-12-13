package christmas.view;

import christmas.util.Utils;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PREVIEW_BENEFIT = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_PRINT = "<주문 메뉴>";
    private static final String ORDER_MENU = "%s %d개\n";
    private static final String ORDER_PRICE_BEFORE_DISCOUNT_PRINT = "<할인 전 총주문 금액>";
    private static final String ORDER_PRICE_BEFORE_DISCOUNT = "%s원\n";
    private static final String GIVE_WAY_PRINT = "<증정 메뉴>";
    private static final String SHAM = "샴페인 1개";
    private static final String NONE = "없음";
    private static final int ZERO = 0;
    private static final String BENEFIT_CONFIG = "<혜택 내역>";
    private static final List<String> BENEFIT_CONFIG_LIST =
            List.of("크리스마스 디데이 할인: -%s원\n",
                    "평일 할인: -%s원\n",
                    "주말 할인: -%s원\n",
                    "특별 할인: -%s원\n",
                    "증정 이벤트: -%s원\n");
    private static final String TOTAL_PAYMENT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String TOTAL_PAYMENT_AFTER_DISCOUNT_DETAIL = "%s원\n";

    private static final String TOTAL_BENEFIT_PRICE = "<총혜택 금액>";
    private static final String TOTAL_BENEFIT_PRICE_DETAIL = "-%s원\n";

    private static final String EVENT_BADGE = "<12월 이벤트 배지>";
    private static final String EVENT_BADGE_DETAIL = "%s";


    public static void previewBenefit(int date) {
        System.out.printf(PREVIEW_BENEFIT, date);
        System.out.println();
    }

    public static void orderMenu(Map<String, Integer> order) {
        System.out.println(ORDER_PRINT);
        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            System.out.printf(ORDER_MENU, menu.getKey(), menu.getValue());
        }
        System.out.println();
    }

    public static void previewOrderPriceBeforeDiscount(int totalPrice) {
        System.out.println(ORDER_PRICE_BEFORE_DISCOUNT_PRINT);
        System.out.printf(ORDER_PRICE_BEFORE_DISCOUNT, Utils.formatPriceToWonType(totalPrice));
        System.out.println();
    }

    public static void previewGiveWay(int totalPrice) {
        System.out.println(GIVE_WAY_PRINT);

        if (totalPrice >= 120000) {
            System.out.println(SHAM);
        }
        if (totalPrice < 120000) {
            System.out.println(NONE);
        }
        System.out.println();
    }

    public static void previewBenefitConfig(List<Integer> totalDiscountConfig) {
        System.out.println(BENEFIT_CONFIG);

        for (int i = 0; i < totalDiscountConfig.size(); i++) {
            if (totalDiscountConfig.get(i) != ZERO) {
                System.out.printf(BENEFIT_CONFIG_LIST.get(i), Utils.formatPriceToWonType(totalDiscountConfig.get(i)));
            }
        }

        if (totalDiscountConfig.stream().allMatch(discount -> discount.equals(ZERO))) {
            System.out.println(NONE);
        }
        System.out.println();
    }

    public static void totalBenefitPrice(int totalBenefit) {
        System.out.println(TOTAL_BENEFIT_PRICE);
        if (totalBenefit == ZERO) {
            System.out.println("0원");
        }
        if (totalBenefit != ZERO){
            System.out.printf(TOTAL_BENEFIT_PRICE_DETAIL, Utils.formatPriceToWonType(totalBenefit));
        }
        System.out.println();
    }

    public static void totalPaymentAfterDiscount(int price) {
        System.out.println(TOTAL_PAYMENT_AFTER_DISCOUNT);
        System.out.printf(TOTAL_PAYMENT_AFTER_DISCOUNT_DETAIL,Utils.formatPriceToWonType(price));
        System.out.println();
    }

    public static void previewEventBadge(String badge) {
        System.out.println(EVENT_BADGE);
        System.out.printf(EVENT_BADGE_DETAIL, badge);
    }
}
