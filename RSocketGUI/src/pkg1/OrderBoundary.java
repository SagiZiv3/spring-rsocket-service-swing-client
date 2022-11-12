package pkg1;

import java.util.Date;

public class OrderBoundary {

    private String orderId;
    private String userEmail;
    private Date createdTimestamp;
    private Date fulfilledTimestamp;
    private ProductBoundary[] products;

    public OrderBoundary(String orderId, String userEmail, ProductBoundary[] products) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getFulfilledTimestamp() {
        return fulfilledTimestamp;
    }

    public void setFulfilledTimestamp(Date fulfilledTimestamp) {
        this.fulfilledTimestamp = fulfilledTimestamp;
    }

    public ProductBoundary[] getProducts() {
        return products;
    }

    public void setProducts(ProductBoundary[] products) {
        this.products = products;
    }

}
