package com.example.products.productManagement.repository;

import com.example.products.productManagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

    List<Product> findByCategoryOrderByPriceAsc(String category);
    List<Product> findByCategoryAndRatingGreaterThanEqual(String category, int rating);

    List<Product> findByCategoryAndPriceLessThanEqual(String category, int price);

    List<Product> findByCategoryAndRatingGreaterThanEqualAndPriceLessThanEqualOrderByPriceAsc(String category, int rating, int price);




}
