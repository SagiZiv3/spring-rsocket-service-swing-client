package pkg1;

public class ProductBoundary {

    private String productId;
    private int quantity;

    public ProductBoundary() {
        this.productId = "";
        this.quantity = 0;
    }

    public ProductBoundary(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductBoundary{" + "productId=" + productId + ", quantity=" + quantity + '}';
    }

}
