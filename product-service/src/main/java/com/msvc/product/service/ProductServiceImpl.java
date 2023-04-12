package com.msvc.product.service;

import com.msvc.product.dto.product.ProductRequestDto;
import com.msvc.product.dto.product.ProductResponseDto;
import com.msvc.product.mapper.ProductMapper;
import com.msvc.product.model.Product;
import com.msvc.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl {

    private ProductRepository productRepository;

    public ProductResponseDto saveProduct(ProductRequestDto productRequest){
        Product product = ProductMapper.INSTANCE.toEntity(productRequest);
        ProductResponseDto productResponse = ProductMapper.INSTANCE
                .toDto(productRepository.save(product));
        log.info("The product {} has been saved into the database",product);
        return productResponse;
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productsResponse = products.stream()
                .map(ProductMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        return productsResponse;
    }

}