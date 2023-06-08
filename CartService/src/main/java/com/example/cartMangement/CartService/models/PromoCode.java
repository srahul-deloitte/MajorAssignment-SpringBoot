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
@Table(name = "promocode")
@Data

public class PromoCode {
    @Id
    Long id;
    String code;
    String percentageoff;
}
