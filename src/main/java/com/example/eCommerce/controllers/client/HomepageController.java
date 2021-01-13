package com.example.eCommerce.controllers.client;

import com.example.eCommerce.controllers.BaseController;
import com.example.eCommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController extends BaseController {

    @GetMapping("/")
    public String getHomepage(){
        return "homepage";
    }
}
