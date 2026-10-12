package se.iths.felix.webshop.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import se.iths.felix.webshop.ConsoleHandler;
import se.iths.felix.webshop.OutInputHandler;
import se.iths.felix.webshop.ProductStorage;
import se.iths.felix.webshop.WebShopManager;

import java.util.List;

public class WebShopManagerTest {
    public ProductStorage storage;
    public WebShopManager webShopManager;
    OutInputHandler myHandler;


    public WebShopManagerTest() {
        this.myHandler = new ConsoleHandler();
        this.storage = new ProductListStorageTest();
        this.webShopManager = new WebShopManager(storage, myHandler);
    }

    @Test
    @DisplayName("Test save two products and controll the size of list")
    public void TestSaveProducts() {

        Product myProduct1 = new Product("1234", "My Product #1", 100, "Test product 1");
        Product myProduct2 = new Product("4321", "My Product #2", 200, "Test product 2");

        webShopManager.saveProductToStorage(myProduct1);
        webShopManager.saveProductToStorage(myProduct2);

        List<Product> products = webShopManager.getProductsFromStorage();

        Assertions.assertEquals(2, products.size());
    }

    @Test
    @DisplayName("Test getting saved product")
    public void TestGetProduct() {
        Product myProduct1 = new Product("1234", "My Product #1", 100, "Test product 1");

        webShopManager.saveProductToStorage(myProduct1);

        Product savedProduct = webShopManager.getProductFromStorage("1234");

        Assertions.assertEquals("1234", savedProduct.getArticleNumber());

    }

    @Test
    @DisplayName("Test looking for a missing product")
    public void TestMissingProduct() {
        Product savedProduct = webShopManager.getProductFromStorage("1234");

        Assertions.assertEquals(null, savedProduct);

    }
}
