package christmas.util;

import christmas.validation.Validations;
import christmas.view.InputView;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final String STAR = "별";
    private static final String TREE = "트리";
    private static final String SANTA = "산타";
    private static final String NONE = "없음";

    private final static String COMMAS = ",";
    private final static String DASH = "-";
    private final static int FOOD_INDEX = 0;
    private final static int COUNT_INDEX = 1;

    public static int stringToInteger() {
        String userInput = InputView.input();
        Validations.validateDateIfNull(userInput);
        Validations.validateDateStringToInteger(userInput);
        Validations.validateDateRangeError(Integer.parseInt(userInput));
        return Integer.parseInt(userInput);
    }

    public static String[] splitStringViaCommas() {
        String userInput = InputView.input();
        Validations.validateOrderIfNull(userInput);
        Validations.validateOrderMenuError(userInput);
        return userInput.split(COMMAS);
    }

    public static Map<String, Integer> splitStringViaDash() {
        String[] userInput = splitStringViaCommas();
        Map<String, Integer> menu = new HashMap<>();

        for (String element : userInput) {
            Validations.validateMenuForm(element.split(DASH));
            Validations.validateMenu(element.split(DASH)[FOOD_INDEX]);
            Validations.validateMenuCount(element.split(DASH)[COUNT_INDEX]);
            menu.put(element.split(DASH)[FOOD_INDEX], Integer.parseInt(element.split(DASH)[COUNT_INDEX]));
        }

        return menu;
    }

    public static String formatPriceToWonType(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }

    public static String searchBadge(int totalBenefit) {
        if (totalBenefit >= 20000) {
            return SANTA;
        }
        if (totalBenefit >= 10000) {
            return TREE;
        }
        if (totalBenefit >= 5000) {
            return STAR;
        }
        return NONE;
    }
}
