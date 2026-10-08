package se.iths.felix.webshop.model;

public class Product {
    private String articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(String articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Product fromFileLine(String line) {
        String[] array = line.split(";");
        String articleNumber = array[0];
        String title = array[1];
        double price = Double.parseDouble(array[2]);
        String description = array[3];
        Product newProduct = new Product(articleNumber, title, price, description);

        return newProduct;
    }

    public String toFileLine() {
        return articleNumber + ";" + title + ";" + price + ";" + description;
    }

    public String toString(){
        return "Article number: "+ articleNumber +
                "Title: " + title +
                "Price: " + price +
                "Description: " + description;
    }
}
