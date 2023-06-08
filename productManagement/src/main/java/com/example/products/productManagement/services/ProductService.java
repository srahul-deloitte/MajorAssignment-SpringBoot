package com.example.products.productManagement.services;

import com.example.products.productManagement.models.Product;
import com.example.products.productManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product getProductById(String productId) {
        // Call your data access layer or repository to retrieve the product by ID
        // Assuming you have a repository named "productRepository" that handles the database operations

        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(productId));
        return optionalProduct.orElse(null);
    }

//    public List<Product> getProductsByCategory(String category) {
//        return productRepository.findByCategory(category);
//    }

    public List<Product> getProductsByCategorySortedByPrice(String category) {
        return productRepository.findByCategoryOrderByPriceAsc(category);
    }

    public List<Product> getProductsByCategoryWithMinimumRating(String category, int rating) {
        return productRepository.findByCategoryAndRatingGreaterThanEqual(category, rating);
    }

//    public List<Product> getProductsByCategoryWithMaximumPrice(String category, int price) {
//        return productRepository.findByCategoryAndPriceLessThanEqual(category, price);
//    }

//    public List<Product> getProductsByCategoryWithMinimumRatingAndMaximumPriceSortedByPrice(String category, int rating, int price) {
//        return productRepository.findByCategoryAndRatingGreaterThanEqualAndPriceLessThanEqualOrderByPriceAsc(category, rating, price); }
}