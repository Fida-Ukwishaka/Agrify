package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.CropRequest;
import org.example.agrify.dto.response.CropResponse;
import org.example.agrify.service.interfaces.CropService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/crops")
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    @PostMapping
    public ResponseEntity<CropResponse> create(@Valid @RequestBody CropRequest request) {
        return new ResponseEntity<>(cropService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CropResponse>> getAll() {
        return ResponseEntity.ok(cropService.getAll());
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<CropResponse> getById(@PathVariable UUID cropId) {
        return ResponseEntity.ok(cropService.getById(cropId));
    }

    @PutMapping("/{cropId}")
    public ResponseEntity<CropResponse> update(@PathVariable UUID cropId,
                                               @Valid @RequestBody CropRequest request) {
        return ResponseEntity.ok(cropService.update(cropId, request));
    }

    @DeleteMapping("/{cropId}")
    public ResponseEntity<String> delete(@PathVariable UUID cropId) {

        cropService.delete(cropId);

        return ResponseEntity.ok("Crop deleted successfully.");
    }
}