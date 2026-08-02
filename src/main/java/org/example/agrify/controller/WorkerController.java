package org.example.agrify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.WorkerRequest;
import org.example.agrify.dto.response.WorkerResponse;
import org.example.agrify.service.interfaces.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity<WorkerResponse> create(@Valid @RequestBody WorkerRequest request) {
        return new ResponseEntity<>(workerService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> getAll() {
        return ResponseEntity.ok(workerService.getAll());
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<WorkerResponse> getById(@PathVariable UUID workerId) {
        return ResponseEntity.ok(workerService.getById(workerId));
    }

    @PutMapping("/{workerId}")
    public ResponseEntity<WorkerResponse> update(@PathVariable UUID workerId,
                                                 @Valid @RequestBody WorkerRequest request) {
        return ResponseEntity.ok(workerService.update(workerId, request));
    }

    @DeleteMapping("/{workerId}")
    public ResponseEntity<String> delete(@PathVariable UUID workerId) {

        workerService.delete(workerId);

        return ResponseEntity.ok("Worker deleted successfully.");
    }
}