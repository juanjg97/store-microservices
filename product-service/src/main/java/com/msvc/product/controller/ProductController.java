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
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId){
        ProductResponseDto productResponseDto = productService.getProduct(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<ProductResponseDto> productsResponseDto = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.CREATED).body(productsResponseDto);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable String productId,@RequestBody ProductRequestDto productRequest){
        ProductResponseDto productResponseDto = productService.updateProduct(productId,productRequest);
        String response = "The product: "+productResponseDto.toString()+" has been updated successfully";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<?> updateProductPrice(@PathVariable String productId,@RequestBody ProductRequestDto productRequest){
        ProductResponseDto productResponseDto = productService.updateProductPrice(productId,productRequest);
        String response = "The product: "+productResponseDto.toString()+" has changed its price";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
        String response = "The product has been deleted";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
