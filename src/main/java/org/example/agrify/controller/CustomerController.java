package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.CustomerRequest;
import org.example.agrify.dto.response.CustomerResponse;
import org.example.agrify.service.interfaces.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerService.getById(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> update(
            @PathVariable UUID customerId,
            @Valid @RequestBody CustomerRequest request) {

        return ResponseEntity.ok(customerService.update(customerId, request));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> delete(@PathVariable UUID customerId) {

        customerService.delete(customerId);

        return ResponseEntity.ok("Customer deleted successfully.");
    }
}