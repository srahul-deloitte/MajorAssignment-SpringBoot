package com.example.cartMangement.CartService.repository;

import com.example.cartMangement.CartService.models.Cart;
import com.example.cartMangement.CartService.models.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocodeRepository extends JpaRepository<PromoCode ,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM promocode where code = :promocode")
    PromoCode findAllByPromoCode(String promocode);
}
