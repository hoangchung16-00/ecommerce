package com.example.eCommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<CartItem>();
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
    }

    public void removeCartItem(Long productId){
        for(int i=0;i<cartItems.size();i++){
            if(productId.equals(cartItems.get(i).getProduct().getId())){
                this.cartItems.remove(i);
                return;
            }
        }
    }

    public CartItem getCartItemByProductId(Long productId){
        for(CartItem cartItem : this.cartItems){
            if(productId.equals(cartItem.getProduct().getId())){
                return cartItem;
            }
        }
        return null;
    }
}
