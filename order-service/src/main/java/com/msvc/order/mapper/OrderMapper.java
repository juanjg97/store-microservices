package com.msvc.order.mapper;

import com.msvc.order.dto.OrderRequestDto;
import com.msvc.order.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order toEntity(OrderRequestDto productRequestDto);
    OrderRequestDto toDto(Order order);
}
