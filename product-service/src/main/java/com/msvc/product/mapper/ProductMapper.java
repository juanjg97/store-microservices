package com.msvc.product.mapper;

import com.msvc.product.dto.product.ProductRequestDto;
import com.msvc.product.dto.product.ProductResponseDto;
import com.msvc.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(uses=ClienteMapper.class)
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductRequestDto ProductRequestDto);
    ProductResponseDto toDto(Product Product);

}
