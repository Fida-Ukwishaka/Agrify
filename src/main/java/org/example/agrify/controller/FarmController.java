package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.FarmRequest;
import org.example.agrify.dto.response.FarmResponse;
import org.example.agrify.service.interfaces.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @PostMapping
    public ResponseEntity<FarmResponse> create(@Valid @RequestBody FarmRequest request) {
        return new ResponseEntity<>(farmService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FarmResponse>> getAll() {
        return ResponseEntity.ok(farmService.getAll());
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<FarmResponse> getById(@PathVariable UUID farmId) {
        return ResponseEntity.ok(farmService.getById(farmId));
    }

    @PutMapping("/{farmId}")
    public ResponseEntity<FarmResponse> update(@PathVariable UUID farmId,
                                               @Valid @RequestBody FarmRequest request) {
        return ResponseEntity.ok(farmService.update(farmId, request));
    }

    @DeleteMapping("/{farmId}")
    public ResponseEntity<String> delete(@PathVariable UUID farmId) {

        farmService.delete(farmId);

        return ResponseEntity.ok("Farm deleted successfully.");
    }
}