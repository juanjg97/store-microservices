package com.msvc.product.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
}
