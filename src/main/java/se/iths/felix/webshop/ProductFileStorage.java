package se.iths.felix.webshop;

import se.iths.felix.webshop.model.Product;

import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileStorage implements ProductStorage {
    private Path file = Path.of("products.txt");

    @Override
    public void saveProduct(Product product) {
        String fileRow = product.toFileLine();
        fileRow += System.lineSeparator();
        try {
            Files.writeString(file,fileRow, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            IO.println("Succesfully wrote to file");
        } catch (IOException e) {
            IO.println("Could not save product to file, Err: " + e.getMessage());
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList();
        IO.println("Hi");
        if(Files.exists(file)){
            try {
                Files.lines(file).forEach(line -> {
                    Product product = Product.fromFileLine(line);
                    products.add(product);
                });
            } catch (IOException e) {
                IO.println("Error occured while reading products from file: " + e.getMessage());
            }
        }
        return products;
    }

    @Override
    public Product getProduct(String articleNumber) {
        List<Product> products = getProducts();

        for(Product p : products){
            if(p.getArticleNumber() == articleNumber){
                return p;
            }
        }
        return null;
    }
}
