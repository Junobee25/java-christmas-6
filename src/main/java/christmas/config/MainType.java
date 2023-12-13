package christmas.config;

public enum MainType {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String mainMenu;
    private final int price;

    MainType(String mainMenu, int price) {
        this.mainMenu = mainMenu;
        this.price = price;
    }

    public String getMenuName() {
        return mainMenu;
    }

    public int getPrice() {
        return price;
    }
}
