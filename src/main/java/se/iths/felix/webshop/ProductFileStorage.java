package se.iths.felix.webshop;

import java.nio.file.Path;

public class ProductFileStorage implements ProductStorage {
    private Path file = Path.of("products.txt");
}
