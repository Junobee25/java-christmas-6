package christmas.config;

public enum BeverageType {
    ZERO_COKE("제로콜라",3000),
    RED_WINE("레드와인",60000),
    CHAMPAGNE("샴페인",25000);

    private final String beverage;
    private final int price;

    BeverageType(String beverage, int price) {
        this.beverage = beverage;
        this.price = price;
    }

    public String getMenuName() {
        return beverage;
    }

    public int getPrice() {
        return price;
    }
}
