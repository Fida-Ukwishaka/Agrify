package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.SaleRequest;
import org.example.agrify.dto.response.SaleResponse;
import org.example.agrify.service.interfaces.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponse> create(@Valid @RequestBody SaleRequest request) {
        return new ResponseEntity<>(saleService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponse>> getAll() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleResponse> getById(@PathVariable UUID saleId) {
        return ResponseEntity.ok(saleService.getById(saleId));
    }

    @PutMapping("/{saleId}")
    public ResponseEntity<SaleResponse> update(
            @PathVariable UUID saleId,
            @Valid @RequestBody SaleRequest request) {

        return ResponseEntity.ok(saleService.update(saleId, request));
    }

    @DeleteMapping("/{saleId}")
    public ResponseEntity<String> delete(@PathVariable UUID saleId) {

        saleService.delete(saleId);

        return ResponseEntity.ok("Sale deleted successfully.");
    }
}