package com.example.eCommerce.controllers.client;

import com.example.eCommerce.models.Cart;
import com.example.eCommerce.models.CartItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AjaxController {
    @GetMapping("/removeCartItem")
    public @ResponseBody String getRemoveCartItem(@RequestParam("productId") Long productId, HttpSession httpSession){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }

        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        CartItem cartItem = cart.getCartItemByProductId(productId);
        if(cartItem!=null){
            cart.removeCartItem(productId);
            httpSession.setAttribute("cart",cart);
        }
        try {
            ajaxResponse = mapper.writeValueAsString(cart);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ajaxResponse;
    }
}
