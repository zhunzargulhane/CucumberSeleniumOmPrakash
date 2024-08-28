package awesomecucumber.domainObjects;

public class Product {
    private String productName;
    private int productId;
    private int productQty;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


}
