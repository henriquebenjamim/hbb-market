package com.hbbMarket.marketplace.DomainTest.Product.services;


import com.hbbMarket.marketplace.exceptions.ProductNotFoundException;
import com.hbbMarket.marketplace.model.Product;
import com.hbbMarket.marketplace.repository.ProductRepository;
import com.hbbMarket.marketplace.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    public void ShouldCreateProduct() {
        // On old method i didn't have the 'check' on save method to confirm the product saved so i used gpt to improve that point
        // Arrange
        Product product = new Product("mouse", 20.9f);

        // Define the behavior of the mocked productRepository.save() method
        when(productRepository.save(any(Product.class))).thenReturn(product); // Assuming save returns the saved product

        // Act
        Product createdProduct = productService.create(product);

        // Assert
        assertNotNull(createdProduct); // Check if a product is returned
        assertEquals("mouse", createdProduct.getName());
        assertEquals(20.9f, createdProduct.getPrice());

        // Verify that the save method was called with the correct product
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void shouldSoftDeleteProduct() {
        // Arrange
        UUID productId = UUID.randomUUID();
        Product productToDelete = new Product(productId, "Mouse", 20.9f,"image.jpg", true); // Assuming isActive is initially true

        // Mock the getProductById method to return the product to delete
        when(productRepository.findById(productId)).thenReturn(Optional.of(productToDelete));
        productRepository.save(productToDelete);

        // Act
        productService.boolDelete(productId);

        // Assert
        // Verify that the save method was called with the correct product
        verify(productRepository, times(1)).save(productToDelete);
        assertFalse(productToDelete.isActive());

    }

    @Test
    public void shouldUpdateProduct() throws ProductNotFoundException {
        // Arrange
        UUID productId = UUID.randomUUID();
        Product updatedProduct = new Product("Updated Mouse", 25.0f); // Updated product data

        // Mock the getProductById method to return the product to update
        when(productRepository.findById(productId)).thenReturn(Optional.of(updatedProduct));

        // Mock the save method behavior to return the updated product
        when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);

        // Act
        Product result = productService.update(productId, updatedProduct);

        // Assert
        assertNotNull(result); // Check if a product is returned
        assertEquals("Updated Mouse", result.getName());
        assertEquals(25.0f, result.getPrice());

        // Verify that the save method was called with the correct product
        verify(productRepository, times(1)).save(updatedProduct);
    }
}
