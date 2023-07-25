package com.msvc.order.mapper;

import com.msvc.order.dto.OrderItemsRequestDto;
import com.msvc.order.dto.OrderRequestDto;
import com.msvc.order.model.Order;
import com.msvc.order.model.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemsMapper {
    OrderItemsMapper INSTANCE = Mappers.getMapper(OrderItemsMapper.class);
    OrderItems toEntity(OrderItemsRequestDto orderItemsRequestDto);


}
