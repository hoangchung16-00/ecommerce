package com.example.eCommerce.models;

public class RemoveCartItem {
    private Long productId;

    public RemoveCartItem(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
