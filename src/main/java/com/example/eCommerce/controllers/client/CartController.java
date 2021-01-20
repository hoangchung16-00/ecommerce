package com.example.eCommerce.controllers.client;

import com.example.eCommerce.controllers.BaseController;
import com.example.eCommerce.models.Cart;
import com.example.eCommerce.models.CartItem;
import com.example.eCommerce.models.Product;
import com.example.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CartController extends BaseController {
    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String getCart(HttpSession httpSession, Model model){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        model.addAttribute("cart",cart);
        return "cart";
    }
    @GetMapping("/add-to-cart")
    public String getAddToCart(@RequestParam("productId") Long productId, HttpSession httpSession){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }
        CartItem cartItem = cart.getCartItemByProductId(productId);
        if(cartItem==null){
            Product product = productService.getProductById(productId);
            cart.addCartItem(new CartItem(product,1,product.getPrice()));
        } else {
            cartItem.setQuantity(cartItem.getQuantity() +1);
            cartItem.setTotalPrice(cartItem.getQuantity()*cartItem.getProduct().getPrice());
        }
        httpSession.setAttribute("cart",cart);
        return "redirect:/cart";
    }
}
