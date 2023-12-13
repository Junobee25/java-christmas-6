package christmas.config;

public enum DessertType {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String dessert;
    private final int price;

    DessertType(String dessert, int price) {
        this.dessert = dessert;
        this.price = price;
    }

    public String getMenuName() {
        return dessert;
    }

    public int getPrice() {
        return price;
    }
}
