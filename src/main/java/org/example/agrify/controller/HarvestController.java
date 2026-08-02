package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.HarvestRequest;
import org.example.agrify.dto.response.HarvestResponse;
import org.example.agrify.service.interfaces.HarvestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/harvests")
@RequiredArgsConstructor
public class HarvestController {

    private final HarvestService harvestService;

    @PostMapping
    public ResponseEntity<HarvestResponse> create(@Valid @RequestBody HarvestRequest request) {
        return new ResponseEntity<>(harvestService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HarvestResponse>> getAll() {
        return ResponseEntity.ok(harvestService.getAll());
    }

    @GetMapping("/{harvestId}")
    public ResponseEntity<HarvestResponse> getById(@PathVariable UUID harvestId) {
        return ResponseEntity.ok(harvestService.getById(harvestId));
    }

    @PutMapping("/{harvestId}")
    public ResponseEntity<HarvestResponse> update(
            @PathVariable UUID harvestId,
            @Valid @RequestBody HarvestRequest request) {

        return ResponseEntity.ok(harvestService.update(harvestId, request));
    }

    @DeleteMapping("/{harvestId}")
    public ResponseEntity<String> delete(@PathVariable UUID harvestId) {

        harvestService.delete(harvestId);

        return ResponseEntity.ok("Harvest deleted successfully.");
    }
}