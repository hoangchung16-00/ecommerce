package com.example.eCommerce.models;

public class Product {
    private Long id;
    private String name;
    private String categoryName;
    private String description;
    private Integer quantity;
    private Float price;
    private String image;

    public Product(Long id, String name, String categoryName, String description, Integer quantity, Float price, String image) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
