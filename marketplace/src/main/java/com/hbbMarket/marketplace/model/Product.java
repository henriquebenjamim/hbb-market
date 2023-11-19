package com.hbbMarket.marketplace.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "Product")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column(scale = 2, columnDefinition = "decimal")
    private Float price;
    private String image;
    @Column(name = "active")
    private Boolean isAvailable;

    public Product(String name, Float price, Boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Boolean isActive() {
        return isAvailable;
    }
}
