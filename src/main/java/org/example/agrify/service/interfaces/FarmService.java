package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.FarmRequest;
import org.example.agrify.dto.response.FarmResponse;

import java.util.List;
import java.util.UUID;

public interface FarmService {

    FarmResponse create(FarmRequest request);

    List<FarmResponse> getAll();

    FarmResponse getById(UUID farmId);

    FarmResponse update(UUID farmId, FarmRequest request);

    void delete(UUID farmId);

}