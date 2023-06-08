package com.example.cartMangement.CartService.service;

import com.example.cartMangement.CartService.entity.Product;
import com.example.cartMangement.CartService.entity.User;
import com.example.cartMangement.CartService.exceptions.ResourceNotFoundException;
import com.example.cartMangement.CartService.fegin.apis.ProductApi;
import com.example.cartMangement.CartService.fegin.apis.UserApi;
import com.example.cartMangement.CartService.models.Cart;
import com.example.cartMangement.CartService.models.Discount;
import com.example.cartMangement.CartService.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductApi productApi;
    @Autowired
    UserApi userApi;
    private static Logger logger = LoggerFactory.getLogger(CartService.class);

    public List<Cart> getCartDetails(Long userid) {
        return cartRepository.findAllById(userid);

    }

    public Cart addToCart(Cart cart) {
        System.out.println(cart.getProductid());
        Optional<Product> p =productApi.getProductId(cart.getProductid());
        System.out.println(p);
        User u = userApi.retrieveUserById(cart.getUserid()).getBody();
        System.out.println(u.getId());
        if(p.get()!=null && u.getId()!=null) {
               return cartRepository.save(cart);
        }
        else{
            logger.error("product or user not found", this.getClass().getName());
            throw  new RuntimeException(" product and user not found");
        }
    }

    public List<Cart> getallcartitems() {
        return cartRepository.findAll();
    }

    public List<Cart> getallcartdeatilsbyuserid(String userid) {
        return cartRepository.findAllByUserId(userid);
    }

    public void deleteItem(Long id) {
        if(cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        } else {
            logger.error("deletePost {} Record not found ", this.getClass().getName());
            throw new ResourceNotFoundException();
        }
    }


}
