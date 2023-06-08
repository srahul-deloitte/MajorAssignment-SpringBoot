package com.example.cartMangement.CartService.service;

import com.example.cartMangement.CartService.entity.Product;
import com.example.cartMangement.CartService.fegin.apis.ProductApi;
import com.example.cartMangement.CartService.models.Cart;
import com.example.cartMangement.CartService.models.Discount;
import com.example.cartMangement.CartService.models.PromoCode;
import com.example.cartMangement.CartService.repository.CartRepository;
import com.example.cartMangement.CartService.repository.DiscountRepository;
import com.example.cartMangement.CartService.repository.PromocodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    ProductApi productApi;
    @Autowired
    PromocodeRepository promocodeRepository;
    @Autowired
    DiscountRepository discountRepository;
    @Autowired
    CartRepository cartRepository;
    private static Logger logger = LoggerFactory.getLogger(CartService.class);
    public List<PromoCode> getDiscounts() {
        return promocodeRepository.findAll();
    }

    public void applyPromoCode(Discount discount) {
        String promocode = discount.getPromocode();
        System.out.println(promocode);
        System.out.println(promocodeRepository.findAllByPromoCode(promocode));
        if(promocodeRepository.findAllByPromoCode(promocode)!=null){
            System.out.println("inside if");
            PromoCode p = promocodeRepository.findAllByPromoCode(promocode);
            Optional<Product> pro = productApi.getProductId(discount.getProductid());

            float price = Float.parseFloat(pro.get().getPrice());
            System.out.println(price);
            float promodiscount = Float.parseFloat(p.getPercentageoff());
            System.out.println(promodiscount);
            price = price - (price * promodiscount)/100;
             Cart cart = new Cart(discount.getCartid(), discount.getProductid(),
                    discount.getUserid(),pro.get().getProducttitle(),
                     pro.get().getCategory(), String.valueOf(price));
            cartRepository.save(cart);

            discountRepository.save(discount);
        }
        else{
            logger.error("Invalid promocode", this.getClass().getName());
            throw  new RuntimeException(" Not a valid promo code");
        }

    }

    public void removeDiscount(Long discount) {
       Optional<Discount> d = discountRepository.findById(discount);
       Optional<Cart> cart = cartRepository.findById(d.get().getCartid());
       Optional<Product> product = productApi.getProductId(d.get().getProductid());
       String actual_price = product.get().getPrice();
       cart.get().setPrice(actual_price);
       cartRepository.save(cart.get());
       discountRepository.deleteById(discount);
    }
}
