package com.example.cartMangement.CartService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
@Data
public class Cart {
    @Id
    private Long id;
    private Long productid;
    private Long userid;
    private String producttitle;
    private String category;
    private String price;
}
