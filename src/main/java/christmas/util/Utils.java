package christmas.util;

import christmas.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private final static String COMMAS = ",";
    private final static String DASH = "-";
    private final static int FOOD_INDEX = 0;
    private final static int COUNT_INDEX = 1;

    public static String[] splitStringViaCommas() {
        String userInput = InputView.input();
        return userInput.split(COMMAS);
    }

    public static Map<String, Integer> splitStringViaDash() {
        String[] userInput = splitStringViaCommas();
        Map<String, Integer> menu = new HashMap<>();

        for (String element : userInput) {
            menu.put(element.split(DASH)[FOOD_INDEX], Integer.parseInt(element.split(DASH)[COUNT_INDEX]));
        }

        return menu;
    }
}
