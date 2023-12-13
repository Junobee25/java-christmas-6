package christmas.service;

import christmas.config.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChristmasService {

    private static final int ZERO = 0;
    private static final int ONE_THOUSAND = 1000;
    private static final int GIVEWAY_EVENT = 120000;
    private static final int GIVEWAY_PRICE = 25000;

    public int totalPurchase(Map<String, Integer> order) {
        int mainPrice = calculateMainPrice(order);
        int dessertPrice = calculateDessertPrice(order);
        int appetizerPrice = calculateAppetizerPrice(order);
        int beveragePrice = calculateBeveragePrice(order);

        return mainPrice + dessertPrice + appetizerPrice + beveragePrice;
    }

    private int calculateMainPrice(Map<String, Integer> order) {
        int mainTotalPrice = 0;
        List<String> mainMenu = Arrays.stream(MainType.values())
                .map(MainType::getMenuName)
                .toList();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (mainMenu.contains(menu.getKey())) {
                mainTotalPrice += calMainPrice(menu.getKey(), menu.getValue());
            }
        }
        return mainTotalPrice;
    }

    private int calMainPrice(String menuName, int menuCount) {
        for (MainType main : MainType.values()) {
            if (menuName.equals(main.getMenuName())) {
                return main.getPrice() * menuCount;
            }
        }
        return ZERO;
    }

    private int calculateDessertPrice(Map<String, Integer> order) {
        int dessertTotalPrice = 0;
        List<String> dessertMenu = Arrays.stream(DessertType.values())
                .map(DessertType::getMenuName)
                .toList();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (dessertMenu.contains(menu.getKey())) {
                dessertTotalPrice += calDessertPrice(menu.getKey(), menu.getValue());
            }
        }
        return dessertTotalPrice;
    }

    private int calDessertPrice(String dessertMenu, int dessertCount) {
        for (DessertType dessert : DessertType.values()) {
            if (dessertMenu.equals(dessert.getMenuName())) {
                return dessert.getPrice() * dessertCount;
            }
        }
        return 0;
    }

    private int calculateAppetizerPrice(Map<String, Integer> order) {
        int appetizerTotalPrice = 0;
        List<String> appetizerMenu = Arrays.stream(AppetizerType.values())
                .map(AppetizerType::getMenuName)
                .toList();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (appetizerMenu.contains(menu.getKey())) {
                appetizerTotalPrice += calAppetizerPrice(menu.getKey(), menu.getValue());
            }
        }
        return appetizerTotalPrice;
    }

    private int calAppetizerPrice(String appetizerMenu, int appetizerCount) {
        for (AppetizerType appetizer : AppetizerType.values()) {
            if (appetizerMenu.equals(appetizer.getMenuName())) {
                return appetizer.getPrice() * appetizerCount;
            }
        }
        return 0;
    }


    private int calculateBeveragePrice(Map<String, Integer> order) {
        int beverageTotalPrice = 0;
        List<String> beverageMenu = Arrays.stream(BeverageType.values())
                .map(BeverageType::getMenuName)
                .toList();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (beverageMenu.contains(menu.getKey())) {
                beverageTotalPrice += calBeveragePrice(menu.getKey(), menu.getValue());
            }
        }
        return beverageTotalPrice;
    }

    private int calBeveragePrice(String beverageMenu, int beverageCount) {
        for (BeverageType beverage : BeverageType.values()) {
            if (beverageMenu.equals(beverage.getMenuName())) {
                return beverage.getPrice() * beverageCount;
            }
        }
        return 0;
    }

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

    public int totalBenefit(int date, Map<String, Integer> order) {
        return totalDiscount(date, order) + totalGiveWay(order);
    }

    public int totalGiveWay(Map<String, Integer> order) {
        if (totalPurchase(order) >= GIVEWAY_EVENT) {
            return GIVEWAY_PRICE;
        }
        return 0;
    }
}
