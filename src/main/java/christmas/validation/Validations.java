package christmas.validation;

import christmas.view.ErrorMessage;

public class Validations {
    public static void validateDateIfNull(String userInput) {
        if (userInput == ""){
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
}
