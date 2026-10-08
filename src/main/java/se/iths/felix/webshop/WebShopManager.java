package se.iths.felix.webshop;

import se.iths.felix.webshop.model.Discount;
import se.iths.felix.webshop.model.HalfPriceDiscount;
import se.iths.felix.webshop.model.Product;
import se.iths.felix.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {
    private ProductStorage productStorage;
    private OutInputHandler handler = new ConsoleHandler();
    Discount discount = null;


    public WebShopManager(ProductStorage productStorage, OutInputHandler handler) {
        this.productStorage = productStorage;
        this.handler = handler;
    }


    public void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    public void getProductsFromStorage() {
        List<Product> products = productStorage.getProducts();
        if (products == null) {
            handler.info("There are currently no products in storage");
        } else {
            for (Product p : products) {
                handler.info(p.toString());
                handler.info("Discounted price: " + discount.calculatePrice(p.getPrice()));
            }
        }
    }

    public void getProductFromStorage(String articleNumber) {
        Product product = productStorage.getProduct(articleNumber);
        if (product == null) {
            handler.info("Product article number provided does not match an existing product");
        } else {
            handler.info(product.toString());
        }
    }

    public void createProduct() {
        String articleNumber = handler.prompt("Input article number: ");
        Product product = productStorage.getProduct(articleNumber);
        if (product != null) {
            handler.info("A product with that article number already exists");
            createProduct();
        } else if (articleNumber.isBlank()) {
            handler.info("Article number can't be blank");
            createProduct();
        }
        String description = handler.prompt("Input description: ");
        String title = handler.prompt("Input Title: ");
        double price = Double.parseDouble(handler.prompt("Input price of product: "));

        Product newProduct = new Product(articleNumber, title, price, description);
        saveProductToStorage(newProduct);
    }


    public void startWebshop() {
        String discountInput = handler.prompt("Input Discount code: ");
        if (discountInput.equals("halfprice")) {
            discount = new HalfPriceDiscount("Half price off: ");
            handler.info("Half price discount applied");
        } else {
            discount = new TenPercentDiscount("Ten percent off: ");
            handler.info("Ten percent discount applied");
        }
        boolean activeShop = true;
        while (activeShop) {
            String choice = handler.menu();
            switch (choice) {
                case "1":
                case "add":
                    createProduct();
                    break;
                case "2":
                case "list":
                    getProductsFromStorage();
                    break;
                case "3":
                case "info":
                    getProductFromStorage(handler.prompt("Input product article number: "));
                    break;
                case "4":
                case "quit":
                    activeShop = false;
                    break;
                default:
                    handler.info("Could not confirm command");
            }
        }
        IO.readln("Goodbye!!!");
    }

}
