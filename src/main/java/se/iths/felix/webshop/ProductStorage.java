package se.iths.felix.webshop;

import se.iths.felix.webshop.model.Product;

import java.util.List;

public interface ProductStorage {
    void saveProduct(Product product);

    List<Product> getProducts();

    Product getProduct(String articleNumber);
}
