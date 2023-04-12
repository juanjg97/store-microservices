package com.msvc.product.controller;

import com.msvc.product.dto.product.ProductRequestDto;
import com.msvc.product.dto.product.ProductResponseDto;
import com.msvc.product.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDto productRequest){
        ProductResponseDto productResponseDto = productService.saveProduct(productRequest);
        String response = "The product: "+productResponseDto.toString()+" has been saved successfully";
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<ProductResponseDto> productsResponseDto = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.CREATED).body(productsResponseDto);
    }
}
