package com.market.connect.repositories;

import com.market.connect.models.entities.Customer;

import java.util.List;

public interface filterCustomerRepository {
    List<Customer> findFilteredCustomers(Boolean isActive, String city, String subscription);
}
