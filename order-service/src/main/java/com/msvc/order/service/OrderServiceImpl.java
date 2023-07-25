package com.msvc.order.service;

import com.msvc.order.dto.OrderRequestDto;
import com.msvc.order.mapper.OrderItemsMapper;
import com.msvc.order.mapper.OrderMapper;
import com.msvc.order.model.Order;
import com.msvc.order.model.OrderItems;
import com.msvc.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl {
    private OrderRepository orderRepository;

    public void createOrder(OrderRequestDto orderRequestDto){
        Order order = OrderMapper.INSTANCE.toEntity(orderRequestDto);

        List<OrderItems> orderItems = orderRequestDto.getOrderItemsRequestsDtos()
                .stream()
                .map(OrderItemsMapper.INSTANCE::toEntity).toList();
        order.setOrderLineItems(orderItems);
    }
}
