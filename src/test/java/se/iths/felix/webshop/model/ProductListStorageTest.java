package se.iths.felix.webshop.model;

import se.iths.felix.webshop.ProductStorage;

import java.util.ArrayList;
import java.util.List;

public class ProductListStorageTest implements ProductStorage {
    List<Product> products = new ArrayList<>();


    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProduct(String articleNumber) {
        for (Product p : products) {
            if (p.getArticleNumber().equals(articleNumber)) {
                return p;
            }
        }
        return null;
    }
}
