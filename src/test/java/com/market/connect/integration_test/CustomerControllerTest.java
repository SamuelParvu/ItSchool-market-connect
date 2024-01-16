package com.market.connect.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.connect.models.dtos.CustomerDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@Transactional
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMVC;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCustomerTestShouldPass() throws Exception{
        CustomerDTO customerDTO = CustomerDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@email.com")
                .build();

        mockMVC.perform(post("/api/customers")
                    .contentType(APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isOk());
    }
}
