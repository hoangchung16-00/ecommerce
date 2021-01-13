package com.example.eCommerce.controllers.admin;

import com.example.eCommerce.forms.LoginForm;
import com.example.eCommerce.models.User;
import com.example.eCommerce.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdminLoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/login")
    public String getAdminLogin(final Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String postAdminLogin(@Valid @ModelAttribute("loginForm") final LoginForm loginForm, BindingResult bindingResult, final Model model, HttpSession httpSession){
        if(bindingResult.hasErrors()){
            return "admin/login";
        }
        if(userService.isCredential(loginForm.getUsername(),loginForm.getPassword(),true)){
            final User user = userService.getUserByUserName(loginForm.getUsername());
            httpSession.setAttribute("loginUserId",user.getId());
            return "redirect:/admin/login";
        }
        return "admin/login";
    }

}
