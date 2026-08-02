package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.FertilizerRequest;
import org.example.agrify.dto.response.FertilizerResponse;
import org.example.agrify.service.interfaces.FertilizerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fertilizers")
@RequiredArgsConstructor
public class FertilizerController {

    private final FertilizerService fertilizerService;

    @PostMapping
    public ResponseEntity<FertilizerResponse> create(@Valid @RequestBody FertilizerRequest request) {
        return new ResponseEntity<>(fertilizerService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FertilizerResponse>> getAll() {
        return ResponseEntity.ok(fertilizerService.getAll());
    }

    @GetMapping("/{fertilizerId}")
    public ResponseEntity<FertilizerResponse> getById(@PathVariable UUID fertilizerId) {
        return ResponseEntity.ok(fertilizerService.getById(fertilizerId));
    }

    @PutMapping("/{fertilizerId}")
    public ResponseEntity<FertilizerResponse> update(
            @PathVariable UUID fertilizerId,
            @Valid @RequestBody FertilizerRequest request) {

        return ResponseEntity.ok(fertilizerService.update(fertilizerId, request));
    }

    @DeleteMapping("/{fertilizerId}")
    public ResponseEntity<String> delete(@PathVariable UUID fertilizerId) {

        fertilizerService.delete(fertilizerId);

        return ResponseEntity.ok("Fertilizer deleted successfully.");
    }
}