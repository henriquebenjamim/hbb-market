package com.hbbMarket.marketplace.service;

import com.hbbMarket.marketplace.exceptions.ProductNotFoundException;
import com.hbbMarket.marketplace.model.Product;
import com.hbbMarket.marketplace.repository.ProductRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product update(UUID id, Product productDetails) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setImage(productDetails.getImage());

            return productRepository.save(existingProduct);
        } else {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    public void boolDelete(UUID id) {
        Product productToDeactivate = productRepository.getById(id);
        productToDeactivate.setIsAvailable(false);
        productRepository.save(productToDeactivate);
    }
}
