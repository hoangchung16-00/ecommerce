package com.example.eCommerce.controllers;

import com.example.eCommerce.models.Category;
import com.example.eCommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseController {
    @Autowired
    protected CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.getListCategory();
    }
}
