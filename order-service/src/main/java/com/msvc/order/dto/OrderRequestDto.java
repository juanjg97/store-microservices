package com.msvc.order.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {
    private List<OrderItemsRequestDto> orderItemsRequestsDtos;
}
