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

    private String name;
    private Float price;
    private String image;
    @Column(name = "active")
    private Boolean isAvailable;
}
