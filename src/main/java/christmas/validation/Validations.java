package christmas.validation;

import christmas.config.Menu;
import christmas.view.ErrorMessage;

import java.util.Arrays;
import java.util.List;
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
}
