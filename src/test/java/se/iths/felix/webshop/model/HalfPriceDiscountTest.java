package se.iths.felix.webshop.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class HalfPriceDiscountTest {
    @Test
    @DisplayName("Test a half price discount returns 50 when provided 100")
    public void testHalfPriceDiscount() {
        //Arrange
        HalfPriceDiscount discount = new HalfPriceDiscount("Half price discount");
        int price = 100;

        //ACT
        double result = discount.calculatePrice(price);

        //Assert
        Assertions.assertEquals(50, result);

    }
}