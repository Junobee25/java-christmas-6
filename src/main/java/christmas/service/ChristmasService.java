package christmas.service;

import christmas.config.DessertType;
import christmas.config.DiscountType;
import christmas.config.MainType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChristmasService {

    private static final int ZERO = 0;
    private static final int ONE_THOUSAND = 1000;

    public int totalDiscount(int date, Map<String, Integer> order) {
        int christmasDiscount = calculateChristmasDiscount(date);
        int mainDiscount = calculateMainDiscount(date, order);
        int dessertDiscount = calculateDessertDiscount(date, order);
        int specialDiscount = calculateSpecialDiscount(date);
        return christmasDiscount + mainDiscount + dessertDiscount + specialDiscount;
    }

    private int calculateChristmasDiscount(int date) {
        if (DiscountType.CHRISTMAS.getDates().contains(date)) {
            return DiscountType.CHRISTMAS.calculate(date);
        }
        return ZERO;
    }

    private int calculateDessertDiscount(int date, Map<String, Integer> order) {
        if (DiscountType.WEEKDAY.getDates().contains(date)) {
            return dessertDiscount(order);
        }
        return 0;
    }

    private int calculateSpecialDiscount(int date) {
        if (DiscountType.SPECIAL.getDates().contains(date)) {
            return ONE_THOUSAND;
        }
        return 0;
    }

    private int dessertDiscount(Map<String, Integer> order) {
        int discount = 0;

        List<String> menuName = Arrays.stream(DessertType.values())
                .map(DessertType::getMenuName)
                .toList();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (menuName.contains(menu.getKey())) {
                discount += menu.getValue() * 2023;
            }
        }
        return discount;
    }

    private int calculateMainDiscount(int date, Map<String, Integer> order) {
        if (DiscountType.WEEKEND.getDates().contains(date)) {
            return mainDiscount(order);
        }
        return 0;
    }

    private int mainDiscount(Map<String, Integer> order) {
        int discount = 0;

        List<String> menuName = Arrays.stream(MainType.values())
                .map(MainType::getMenuName)
                .toList();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (menuName.contains(menu.getKey())) {
                discount += menu.getValue() * 2023;
            }
        }
        return discount;
    }
}
