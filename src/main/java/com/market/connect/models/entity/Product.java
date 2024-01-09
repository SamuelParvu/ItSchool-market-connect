package com.market.connect.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @ElementCollection
    @CollectionTable(name = "customer_ratings", joinColumns = @JoinColumn(name="customer_id"))
    @MapKeyColumn(name = "customer_email")
    @Column(name = "ratings")
    private Map<Customer,Double> customerRatings;

    @ElementCollection
    @CollectionTable(name = "customer_ratings", joinColumns = @JoinColumn(name="customer_id"))
    @MapKeyColumn(name = "customer_email")
    @Column(name = "reviews")
    private Map<Customer, String> customerReviews;

    @Column(name = "product_price")
    private Double productPrice;
    @Column(name = "product_category")
    private ProductCategory productCategory;
    @Column(name = "product_description")
    private String description;
}
