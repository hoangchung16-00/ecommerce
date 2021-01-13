package com.example.eCommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddCategoryForm {

    @NotBlank(message = "Name can not blank")
    private String name;
    @Min(value = 1,message = "Sorting Invalid")
    private Integer sorting;

    public AddCategoryForm() {
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

    public AddCategoryForm(String name, Integer sorting) {
        this.name = name;
        this.sorting = sorting;
    }
}
