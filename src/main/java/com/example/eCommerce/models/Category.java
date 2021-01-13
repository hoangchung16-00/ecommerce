package com.example.eCommerce.models;

public class Category {
    private Long id;
    private String name;
    private String slug;
    private Integer sorting;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public Integer getSorting() {
        return sorting;
    }

    public Category(Long id, String name, String slug, Integer sorting) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
    }
}
