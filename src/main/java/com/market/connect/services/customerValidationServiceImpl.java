package com.market.connect.services;

import com.market.connect.exceptions.DuplicateCustomerException;
import com.market.connect.models.dtos.CustomerDTO;
import com.market.connect.models.entities.Customer;
import com.market.connect.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class customerValidationServiceImpl implements customerValidationService {
    private final CustomerRepository customerRepository;

    public customerValidationServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void validateUniqueCustomer(CustomerDTO customerDTO) {
        Customer foundCustomer = customerRepository.findByEmail(customerDTO.getEmail());
        if (foundCustomer != null) {
            throw new DuplicateCustomerException("email already exists.");
        }
    }
}
