package christmas.domain;

import java.util.Map;

public class Order {

    private final Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        this.order = order;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }
}
