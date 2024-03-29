package com.market.connect.models.entities;

import com.market.connect.utils.SubscriptionCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "city")
    private String city;
    @Column(name = "subscription")
    private SubscriptionCategory subscription;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
