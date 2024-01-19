package com.market.connect.controllers;

import com.market.connect.models.dtos.CustomerDTO;
import com.market.connect.models.entities.Customer;
import com.market.connect.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    // create customer api (post)

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> filteredCustomer(@RequestParam Boolean isActive,
                                                              @RequestParam String city,
                                                              @RequestParam String subscription){
        return ResponseEntity.ok(customerService.getFilteredCustomers(isActive,city,subscription));
    }
}
