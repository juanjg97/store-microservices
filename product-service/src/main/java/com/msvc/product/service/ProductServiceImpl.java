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
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductResponseDto saveProduct(ProductRequestDto productRequest){
        Product product = ProductMapper.INSTANCE.toEntity(productRequest);
        ProductResponseDto productResponse = ProductMapper.INSTANCE
                .toDto(productRepository.save(product));
        log.info("The product {} has been saved into the database",product);
        return productResponse;
    }

    @Override
    public ProductResponseDto getProduct(String productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        ProductResponseDto productResponse = ProductMapper.INSTANCE.toDto(product);
        log.info("The product {} has been gotten from the database",product);
        return productResponse;
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productsResponse = products.stream()
                .map(ProductMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        log.info("The products have been gotten from the database");
        return productsResponse;
    }

    @Override
    public ProductResponseDto updateProduct(String id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductMapper.INSTANCE.updateProductFromDto(productRequestDto, product);
        return ProductMapper.INSTANCE.toDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto updateProductPrice(String id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setPrice(productRequestDto.getPrice());
        return ProductMapper.INSTANCE.toDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
    }

}