package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.WorkerRequest;
import org.example.agrify.dto.response.WorkerResponse;

import java.util.List;
import java.util.UUID;

public interface WorkerService {

    WorkerResponse create(WorkerRequest request);

    List<WorkerResponse> getAll();

    WorkerResponse getById(UUID workerId);

    WorkerResponse update(UUID workerId, WorkerRequest request);

    void delete(UUID workerId);

}