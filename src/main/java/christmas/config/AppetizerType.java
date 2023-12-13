package christmas.config;

public enum AppetizerType {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String appetizer;
    private final int price;

    AppetizerType(String appetizer, int price) {
        this.appetizer = appetizer;
        this.price = price;
    }

    public String getMenuName() {
        return appetizer;
    }

    public int getPrice() {
        return price;
    }

}
