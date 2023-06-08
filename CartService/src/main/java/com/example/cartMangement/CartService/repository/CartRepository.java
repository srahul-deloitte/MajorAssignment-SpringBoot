package com.example.cartMangement.CartService.repository;

import com.example.cartMangement.CartService.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllById(Long userid);
    @Query(nativeQuery = true, value = "SELECT * FROM cart where userid = :userid")
     List<Cart> findAllByUserId(String userid);
}
