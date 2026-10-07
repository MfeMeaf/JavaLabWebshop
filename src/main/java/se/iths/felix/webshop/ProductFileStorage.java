package se.iths.felix.webshop;

import se.iths.felix.webshop.model.Product;

import java.nio.file.Path;
import java.util.List;

public class ProductFileStorage implements ProductStorage {
    private Path file = Path.of("products.txt");

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
