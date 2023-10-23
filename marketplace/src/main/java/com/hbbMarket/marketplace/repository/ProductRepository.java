package com.hbbMarket.marketplace.repository;

import com.hbbMarket.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository <Product, UUID> {

    Optional<Product> findById(UUID id);
}
