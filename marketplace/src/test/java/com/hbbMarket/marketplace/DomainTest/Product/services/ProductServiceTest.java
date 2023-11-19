package com.hbbMarket.marketplace.DomainTest.Product.services;


import com.hbbMarket.marketplace.model.Product;
import com.hbbMarket.marketplace.repository.ProductRepository;
import com.hbbMarket.marketplace.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    public void ShoudlCreateProduct() {

        //Arrange
        Product product = new Product("mouse", 20.9f);

        //Act
        productService.create(product);

        //Assert
        assertEquals("mouse", product.getName());
        assertEquals(20.9f, product.getPrice());
    }

}
