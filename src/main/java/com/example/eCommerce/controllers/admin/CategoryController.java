package com.example.eCommerce.controllers.admin;

import com.example.eCommerce.forms.AddCategoryForm;
import com.example.eCommerce.forms.EditCategoryForm;
import com.example.eCommerce.forms.LoginForm;
import com.example.eCommerce.models.Category;
import com.example.eCommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/add-category")
    public String getAddCategory(final Model model){
        model.addAttribute("addCategoryForm",new AddCategoryForm());
        return "admin/add-category";
    }

    @PostMapping("/admin/add-category")
    public String postAddCategory(@Valid @ModelAttribute("addCategoryForm") final AddCategoryForm addCategoryForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/add-category";
        }
        categoryService.addCategory(addCategoryForm.getName(),addCategoryForm.getSorting());
        return "redirect:list-category";
    }

    @GetMapping("/admin/list-category")
    public String getListCategory(final Model model){
        List<Category> categories = categoryService.getListCategory();
        model.addAttribute("categories",categories);
        return "admin/list-category";
    }
    @GetMapping("admin/delete-category")
    public String getDeleteCategory(@RequestParam("categoryId") final Long categoryId){
        categoryService.deleteCategory(categoryId);
        return "redirect:list-category";
    }
    @GetMapping("/admin/edit-category")
    public String getEditCategory(@RequestParam("categoryId") final Long categoryId,final Model model){
        EditCategoryForm editCategoryForm = categoryService.getEditCategoryFormById(categoryId);
        model.addAttribute("editCategoryForm",editCategoryForm);
        return "admin/editCategory";
    }

    @PostMapping("/admin/edit-category")
    public String postEditCategory(@Valid @ModelAttribute("editCategoryForm") EditCategoryForm editCategoryForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/editCategory";
        }
        categoryService.editCategory(editCategoryForm.getName(),editCategoryForm.getSorting(),editCategoryForm.getId());
        return "redirect:list-category";
    }

}
