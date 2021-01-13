package com.example.eCommerce.controllers.client;

import com.example.eCommerce.controllers.BaseController;
import com.example.eCommerce.services.CategoryService;
import com.example.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopCategoryController extends BaseController {
    private final int PAGE_SIZE = 3;

    @Autowired
    private ProductService productService;

    @GetMapping("/category/{categorySlug}")
    public String getShopCategory(@PathVariable("categorySlug") String categorySlug, @RequestParam(value = "page",required = false,defaultValue = "1") Integer page, final Model model){
        if(!categoryService.checkCategorySlug(categorySlug)){
            return "404";
        }
        model.addAttribute("products",productService.getListProductByCategorySlug(categorySlug,page,PAGE_SIZE));
        model.addAttribute("totalPage",productService.getTotalProductByCategorySlug(categorySlug)/PAGE_SIZE + 1);
        model.addAttribute("currentPage",page);
        model.addAttribute("currentCategorySlug",categorySlug);
        return "listProductByCategory";
    }
}
