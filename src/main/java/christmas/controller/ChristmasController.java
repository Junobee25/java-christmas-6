package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.ChristmasService;
import christmas.util.Utils;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasController {

    private final ChristmasService christmasService;

    public ChristmasController() {
        christmasService = new ChristmasService();
    }

    public void promotionEvent() {
        int date = inputDate();
        Map<String, Integer> order = inputOrder();
        showOrderResult(date, order);

    }

    private void showOrderResult(int date, Map<String ,Integer> order) {
        OutputView.previewBenefit(date);
        OutputView.orderMenu(order);
        OutputView.previewOrderPriceBeforeDiscount(christmasService.totalPurchase(order));
        OutputView.previewGiveWay(christmasService.totalPurchase(order));
        OutputView.previewBenefitConfig(christmasService.totalConfig(date, order));
        OutputView.totalBenefitPrice(christmasService.totalBenefit(date, order));
        OutputView.totalPaymentAfterDiscount(christmasService.totalPurchase(order) - christmasService.totalDiscount(date, order));
        OutputView.previewEventBadge(Utils.searchBadge(christmasService.totalBenefit(date, order)));

    }

    public int inputDate() {
        InputView.welcome();

        while (true) {
            try {
                Date date = new Date(Utils.stringToInteger());
                return date.getDate();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public Map<String, Integer> inputOrder() {
        InputView.inputOrderAndCount();

        while (true) {
            try {
                Order order = new Order(Utils.splitStringViaDash());
                return order.getOrder();
            } catch (IllegalArgumentException e) {

            }
        }
    }

}
