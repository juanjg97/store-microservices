package com.msvc.order.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemsRequestDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
