package com.msvc.product.service;

import com.msvc.product.dto.product.ProductRequestDto;
import com.msvc.product.dto.product.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto saveProduct(ProductRequestDto productRequest);
    ProductResponseDto getProduct(String productId);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateProduct(String id, ProductRequestDto productRequest);
    ProductResponseDto updateProductPrice(String id, ProductRequestDto productRequestDto);

    void deleteProduct(String id);

}
