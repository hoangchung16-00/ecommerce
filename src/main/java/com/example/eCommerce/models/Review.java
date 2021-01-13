package com.example.eCommerce.models;

public class Review {
    private Long id;
    private Long product_id;
    private int rating;
    private String name;
    private String description;

    public Review(Long id, Long product_id, int rating, String name, String description) {
        this.id = id;
        this.product_id = product_id;
        this.rating = rating;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
}
