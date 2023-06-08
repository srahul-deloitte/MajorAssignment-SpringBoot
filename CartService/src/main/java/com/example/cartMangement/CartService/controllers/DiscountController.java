package com.example.cartMangement.CartService.controllers;

import com.example.cartMangement.CartService.models.Discount;
import com.example.cartMangement.CartService.models.PromoCode;
import com.example.cartMangement.CartService.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/discount")
@RestController
public class DiscountController {
    @Autowired
    DiscountService discountService;
    @GetMapping("/alldiscounts")
    public List<PromoCode> getAllDiscounts(){
        return discountService.getDiscounts();
    }
    @PostMapping("/applypromocode")
    public HttpStatus applyPromoCode(@RequestBody Discount discount){
        discountService.applyPromoCode(discount);
        return HttpStatus.ACCEPTED;
    }
    @PostMapping("/removediscount/{discountid}")
    public HttpStatus removeDiscount(@PathVariable Long discountid){
        discountService.removeDiscount(discountid);
        return HttpStatus.ACCEPTED;
    }
}
