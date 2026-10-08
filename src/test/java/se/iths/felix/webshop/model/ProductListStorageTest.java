package se.iths.felix.webshop.model;

import se.iths.felix.webshop.ProductStorage;

import java.util.List;

public class ProductListStorageTest implements ProductStorage {
    List<Product> products;

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public List<Product> getProducts() {

        return List.of();
    }

    @Override
    public Product getProduct(String articleNumber) {
        return null;
    }
}
