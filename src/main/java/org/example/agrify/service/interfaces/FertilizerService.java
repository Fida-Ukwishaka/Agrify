package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.FertilizerRequest;
import org.example.agrify.dto.response.FertilizerResponse;

import java.util.List;
import java.util.UUID;

public interface FertilizerService {

    FertilizerResponse create(FertilizerRequest request);

    List<FertilizerResponse> getAll();

    FertilizerResponse getById(UUID fertilizerId);

    FertilizerResponse update(UUID fertilizerId, FertilizerRequest request);

    void delete(UUID fertilizerId);
}