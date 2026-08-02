package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.CustomerRequest;
import org.example.agrify.dto.response.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerResponse create(CustomerRequest request);

    List<CustomerResponse> getAll();

    CustomerResponse getById(UUID customerId);

    CustomerResponse update(UUID customerId, CustomerRequest request);

    void delete(UUID customerId);
}