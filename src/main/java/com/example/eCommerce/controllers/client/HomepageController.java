package com.example.eCommerce.controllers.client;

import com.example.eCommerce.DAOs.CategoryDAO;
import com.example.eCommerce.controllers.BaseController;
import com.example.eCommerce.entitys.Categories;
import com.example.eCommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomepageController extends BaseController {
    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    @GetMapping("/")
    public String getHomepage(){
        List<Categories> categories = categoryDAO.findAll();
        return "homepage";
    }
}
