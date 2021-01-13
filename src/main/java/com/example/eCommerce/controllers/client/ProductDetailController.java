package com.example.eCommerce.controllers.client;

import com.example.eCommerce.services.ProductService;
import com.example.eCommerce.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/product-detail/{productId}")
    public String getProductDetail(@PathVariable("productId") Long productId, final Model model){
        if(productService.getProductById(productId) == null){
            return "404";
        }
        model.addAttribute("reviews",reviewService.getReviewsByProductId(productId));
        model.addAttribute("product",productService.getProductById(productId));
        return "product-detail";
    }
}
