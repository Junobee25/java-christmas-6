package christmas.config;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum DiscountType {
    WEEKDAY(Arrays.asList(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31), value -> value - 2023),
    WEEKEND(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), value -> value - 2023),
    CHRISTMAS(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 29, 20, 21, 22, 23, 24, 25), value -> 1000 + 100 * (value - 1)),
    SPECIAL(Arrays.asList(3, 10, 17, 24, 25, 31), value -> value - 1000);

    private final List<Integer> dates;
    private final Function<Integer, Integer> expression;


    DiscountType(List<Integer> dates, Function<Integer, Integer> expression) {
        this.dates = dates;
        this.expression = expression;
    }

    public List<Integer> getDates() {
        return dates;
    }

    public int calculate(int value) {
        return expression.apply(value);
    }
}
