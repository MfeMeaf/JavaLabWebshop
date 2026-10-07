package se.iths.felix.webshop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TenPercentDiscountTest {

    @Test
    @DisplayName("Test that calculate price returns 90 when provided 100")
    public void testTenPercentDiscount() {
        //Arrange
        TenPercentDiscount discount = new TenPercentDiscount("Ten percent discount");
        int price = 100;

        //ACT
        double result = discount.calculatePrice(price);

        //Assert
        Assertions.assertEquals(90, result);
    }
}