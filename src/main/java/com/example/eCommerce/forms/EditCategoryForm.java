package com.example.eCommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EditCategoryForm {

    private Long id;
    @NotBlank(message = "Name can not blank")
    private String name;

    @Min(value = 1, message = "Quantity Invalid")
    private Integer sorting;

    public EditCategoryForm(Long id, @NotBlank(message = "Name can not blank") String name, @Min(1) Integer sorting) {
        this.id = id;
        this.name = name;
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

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }
}
