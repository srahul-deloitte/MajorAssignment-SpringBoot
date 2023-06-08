package com.example.cartMangement.CartService.controllers;

import com.example.cartMangement.CartService.models.Cart;
import com.example.cartMangement.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping()
    public List<Cart> getAllCartItems() {
        return cartService.getallcartitems();
    }

    @GetMapping("/cartdetailsbyuserid/{userid}")
    public List<Cart> getAllCartDetailByUserId(@PathVariable String userid) {
        return cartService.getallcartdeatilsbyuserid(userid);
    }

    @GetMapping("/cartdetails/{cartid}")
    public List<Cart> getCartDetailsByID(@PathVariable Long cartid) {
        return cartService.getCartDetails(cartid);
    }

    @PostMapping("/addtocart")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @DeleteMapping("/{cartid}")
    public HttpStatus deleteItemFromCart(@PathVariable Long cartid) {
        cartService.deleteItem(cartid);
        return HttpStatus.ACCEPTED;
    }
}