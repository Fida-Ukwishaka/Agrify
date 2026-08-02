package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.CustomerRequest;
import org.example.agrify.dto.response.CustomerResponse;
import org.example.agrify.entity.Customer;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.CustomerMapper;
import org.example.agrify.repository.CustomerRepository;
import org.example.agrify.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse create(CustomerRequest request) {

        Customer customer = customerMapper.toEntity(request);

        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public List<CustomerResponse> getAll() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse getById(UUID customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        return customerMapper.toResponse(customer);
    }

    @Override
    public CustomerResponse update(UUID customerId, CustomerRequest request) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customerMapper.updateEntity(request, customer);

        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public void delete(UUID customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customerRepository.delete(customer);
    }
}