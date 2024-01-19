package com.market.connect.repositories;

import com.market.connect.models.dtos.CustomerDTO;
import com.market.connect.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, filterCustomerRepository {

    Customer findByEmail(String email);

//    List<Customer> findCustomersByActiveIsAndCityAndSubscription();
}
