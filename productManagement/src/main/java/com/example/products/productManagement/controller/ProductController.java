package com.example.products.productManagement.controller;

import com.example.products.productManagement.models.Product;
import com.example.products.productManagement.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

//    @GetMapping("/category/{category}")
//    public List<Product> getProductsByCategory(@PathVariable String category) {
//        return productService.getProductsByCategory(category);
//    }

    @GetMapping("/category/{category}/sortedByPrice")
    public List<Product> getProductsByCategorySortedByPrice(@PathVariable String category) {
        return productService.getProductsByCategorySortedByPrice(category);
    }

    @GetMapping("/category/{category}/rating/{rating}") public List<Product> getProductsByCategoryWithMinimumRating(@PathVariable String category, @PathVariable int rating) {
        return productService.getProductsByCategoryWithMinimumRating(category, rating);
    }
//    @GetMapping("/category/{category}/price/{price}") public List<Product> getProductsByCategoryWithMaximumPrice(@PathVariable String category, @PathVariable int price) {
//        return productService.getProductsByCategoryWithMaximumPrice(category, price);
//    }
//    @GetMapping("/category/{category}/rating/{rating}/price/{price}/sortedByPrice") public List<Product> getProductsByCategoryWithMinimumRatingAndMaximumPriceSortedByPrice( @PathVariable String category, @PathVariable int rating, @PathVariable int price) {
//        return productService.getProductsByCategoryWithMinimumRatingAndMaximumPriceSortedByPrice(category, rating, price);
//    }

}
