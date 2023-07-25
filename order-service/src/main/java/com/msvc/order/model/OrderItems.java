package com.msvc.order.model;

import lombok.*;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_line_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
