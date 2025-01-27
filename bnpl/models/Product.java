package models;

public class Product {

    Integer productId;
    String productName;
    Integer quantity;
    Integer price;

    public Product(String productName, Integer quantity, Integer price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(Integer productId, String productName, Integer quantity, Integer price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
