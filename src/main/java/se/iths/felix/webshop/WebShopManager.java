package se.iths.felix.webshop;

import se.iths.felix.webshop.model.Discount;
import se.iths.felix.webshop.model.HalfPriceDiscount;
import se.iths.felix.webshop.model.Product;
import se.iths.felix.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {
    public void saveProductToStorage(Product Product) {
    }

    ;

    public void getProductsFromStorage() {
    }

    ;

    public void startWebshop() {
//        String discountInput = IO.readln("Input Discount code: ");
//        Discount discount = null;
//        if (discountInput.equals("halfprice")) {
//            discount = new HalfPriceDiscount("Half price off: ");
//            IO.println("Half price discount applied");
//        } else {
//            discount = new TenPercentDiscount("Ten percent off: ");
//            IO.println("Ten percent discount applied");
//        }
//        Product myProduct = new Product("1234321", "The Best Kebab", 75,"Kebab made by the best cook");
        ProductFileStorage myFileStorage = new ProductFileStorage();
//        myFileStorage.saveProduct(myProduct);
        myFileStorage.getProducts();

    }

}
