package com.hbbMarket.marketplace.controller;

import com.hbbMarket.marketplace.exceptions.ProductNotFoundException;
import com.hbbMarket.marketplace.model.Product;
import com.hbbMarket.marketplace.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@Tag(name = "product-controller")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "CREATE a product")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @Operation(summary = "READ All Products")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.list();
    }

    @Operation(summary = "UPDATE a product")
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product productDetails) throws ProductNotFoundException {
        Product newProd = productService.update(id, productDetails);
        return new ResponseEntity<>(newProd, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "DELETE a product(BOOL)")
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") UUID id) {
        productService.boolDelete(id);
    }
}
