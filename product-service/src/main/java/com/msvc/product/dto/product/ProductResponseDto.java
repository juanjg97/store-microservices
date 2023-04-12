package com.msvc.product.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponseDto {
    private String name;
    private BigDecimal price;
}
