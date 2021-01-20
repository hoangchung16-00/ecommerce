package com.example.eCommerce.forms;

import javax.validation.constraints.NotBlank;

public class RemoveCartItemForm {
    @NotBlank
    Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
