package com.example.cartMangement.CartService.repository;

import com.example.cartMangement.CartService.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
