package com.hbbMarket.marketplace.controller;

import com.hbbMarket.marketplace.exceptions.ProductNotFoundException;
import com.hbbMarket.marketplace.model.Product;
import com.hbbMarket.marketplace.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody @Valid Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> get() {
        return productService.list();
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> put(@PathVariable UUID id, @RequestBody Product productDetails) throws ProductNotFoundException {
        Product newProd = productService.update(id, productDetails);
        return new ResponseEntity<>(newProd, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        productService.boolDelete(id);
    }
}
