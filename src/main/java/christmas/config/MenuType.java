package christmas.config;

import java.util.Arrays;
import java.util.List;

public enum MenuType {

    APPETIZER(Arrays.asList("양송이수프", "타파스", "시저샐러드")),
    DESSERT(Arrays.asList("초코케이크", "아이스크림", "티본스테이크")),
    MAIN(Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타")),
    BEVERAGE(Arrays.asList("제로콜라", "레드와인", "샴페인"));

    private final List<String> menu;

    MenuType(List<String> menu) {
        this.menu = menu;
    }

    public List<String> getMenuList() {
        return menu;
    }
}
