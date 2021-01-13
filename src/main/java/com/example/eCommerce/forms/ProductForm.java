package com.example.eCommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductForm {
    private Long id;

    @NotBlank(message = "Name can not blank")
    private String name;

    @NotBlank(message = "Description can not blank")
    private String description;

    @Min(value = 1,message = "Quantity Invalid")
    private Integer quantity;

    @Min(value = 1,message = "Price Invalid")
    private Float price;

    @NotNull(message = "Category Invaliid")
    private Long categoryId;

    public ProductForm(Long id, @NotBlank(message = "Name can not blank") String name, @NotBlank(message = "Description can not blank") String description, @Min(value = 1, message = "Quantity Invalid") Integer quantity, @Min(value = 1, message = "Price Invalid") Float price, @NotNull(message = "Category Invaliid") Long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
    }

    public ProductForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }




}
