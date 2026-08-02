package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.EquipmentRequest;
import org.example.agrify.dto.response.EquipmentResponse;
import org.example.agrify.service.interfaces.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<EquipmentResponse> create(@Valid @RequestBody EquipmentRequest request) {
        return new ResponseEntity<>(equipmentService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EquipmentResponse>> getAll() {
        return ResponseEntity.ok(equipmentService.getAll());
    }

    @GetMapping("/{equipmentId}")
    public ResponseEntity<EquipmentResponse> getById(@PathVariable UUID equipmentId) {
        return ResponseEntity.ok(equipmentService.getById(equipmentId));
    }

    @PutMapping("/{equipmentId}")
    public ResponseEntity<EquipmentResponse> update(
            @PathVariable UUID equipmentId,
            @Valid @RequestBody EquipmentRequest request) {

        return ResponseEntity.ok(equipmentService.update(equipmentId, request));
    }

    @DeleteMapping("/{equipmentId}")
    public ResponseEntity<String> delete(@PathVariable UUID equipmentId) {

        equipmentService.delete(equipmentId);

        return ResponseEntity.ok("Equipment deleted successfully.");
    }
}