package se.iths.felix.webshop;

public class Main {
    static void main() {
        ProductFileStorage myStorage = new ProductFileStorage();
        OutInputHandler myHandler = new ConsoleHandler();
        WebShopManager myWebshop = new WebShopManager(myStorage, myHandler);
        myWebshop.startWebshop();
    }
}
