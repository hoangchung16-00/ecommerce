package com.example.eCommerce.services;

import com.example.eCommerce.forms.AddCategoryForm;
import com.example.eCommerce.forms.EditCategoryForm;
import com.example.eCommerce.models.Category;
import com.example.eCommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void addCategory(final String name,final Integer sorting){
         final String slug = name.toLowerCase().replaceAll(" ","-");
        categoryRepository.addCategory(name,sorting,slug);
    }

    @Transactional
    public List<Category> getListCategory(){
        return categoryRepository.getListCategory();
    }

    @Transactional
    public void deleteCategory(final Long id){
        categoryRepository.deleteCategory(id);
    }

    @Transactional
    public EditCategoryForm getEditCategoryFormById(final Long id){
        return categoryRepository.getEditCategoryFormById(id);
    }

    @Transactional
    public void editCategory(final String name,final Integer sorting,final Long id){
        categoryRepository.editCategory(name,sorting,id);
    }

    @Transactional
    public Boolean checkCategorySlug(String categorySlug){
        return categoryRepository.checkCategorySlug(categorySlug);
    }
}
