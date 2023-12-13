package christmas.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasServiceTest {
    private ChristmasService christmasService;

    @BeforeEach
    void setUp() {
        christmasService = new ChristmasService();
    }

    @Test
    void totalDiscount() {
        //Given
        Map<String, Integer> menu;
        menu = Map.ofEntries(
                Map.entry("티본스테이크", 1),
                Map.entry("바비큐립", 1),
                Map.entry("초코케이크", 2),
                Map.entry("제로콜라", 1));

        int date = 3;

        //When
        int result1 = christmasService.totalDiscount(3, menu);


        //Then
        assertEquals(result1, 6246);
    }

    @Test
    void totalPurchase() {
        //Given
        Map<String, Integer> menu;
        menu = Map.ofEntries(
                Map.entry("티본스테이크", 1),
                Map.entry("바비큐립", 1),
                Map.entry("초코케이크", 2),
                Map.entry("제로콜라", 1));


        //When
        int result1 = christmasService.totalPurchase(menu);


        //Then
        assertEquals(result1, 142000);
    }

}