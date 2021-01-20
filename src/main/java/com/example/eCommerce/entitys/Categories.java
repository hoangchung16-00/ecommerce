package com.example.eCommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String  slug;
    private Integer sorting;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Products> products;
    public Categories() {
    }

    public Categories(String name, String slug, Integer sorting) {
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }
}
