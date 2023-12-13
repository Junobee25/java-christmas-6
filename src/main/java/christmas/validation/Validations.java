package christmas.validation;

import christmas.config.Menu;
import christmas.config.MenuType;
import christmas.view.ErrorMessage;

import java.util.*;
import java.util.regex.Pattern;

public class Validations {
    public static void validateDateIfNull(String userInput) {
        if (userInput == "") {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateDateStringToInteger(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateDateRangeError(int date) {
        if (date > 31 || date < 1) {
            ErrorMessage.inputDateError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateOrderIfNull(String userInput) {
        if (userInput == "") {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateOrderMenuError(String userInput) {
        if (Pattern.compile(",{2,}").matcher(userInput).find()) {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenuForm(String[] userInput) {
        if (userInput.length != 2) {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenu(String userInput) {
        if (!Menu.MENU_List.getMenuList().contains(userInput)) {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenuCount(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit) || userInput == "0") {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateOnlyBeverage(Map<String, Integer> order) {
        Set<MenuType> distinctMenuTypes = new HashSet<>();
        MenuType[] menuTypes = MenuType.values();

        for (MenuType menuType : menuTypes) {
            distinctMenuTypes.addAll(addMenuType(menuType, order));
        }

        if (distinctMenuTypes.size() == 1 && distinctMenuTypes.contains(MenuType.BEVERAGE)) {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateMenuCountOver(Map<String, Integer> order) {
        int totalCount = 0;

        for(Map.Entry<String, Integer> menu : order.entrySet()) {
            totalCount += menu.getValue();
        }

        if (totalCount > 20) {
            ErrorMessage.inputOrderError();
            throw new IllegalArgumentException();
        }


    }

    private static Set<MenuType> addMenuType(MenuType menuType, Map<String, Integer> order) {
        Set<MenuType> menuTypes = new HashSet<>();

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            if (menuType.getMenuList().contains(menu.getKey())) {
              menuTypes.add(menuType);
            }
        }

        return menuTypes;
    }
}
