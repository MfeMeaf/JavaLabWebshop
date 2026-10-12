package se.iths.felix.webshop;

import se.iths.felix.webshop.model.Product;

import java.util.List;

public class ProductListStorage implements ProductStorage {
    List<Product> products;


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
