package com.example.cartMangement.CartService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount")
@Data
public class Discount {
    @Id
    private Long id;
    private Long cartid;
    private Long productid;
    private Long userid;
    private String promocode;
}
