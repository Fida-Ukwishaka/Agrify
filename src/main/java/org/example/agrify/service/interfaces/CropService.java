package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.CropRequest;
import org.example.agrify.dto.response.CropResponse;

import java.util.List;
import java.util.UUID;

public interface CropService {

    CropResponse create(CropRequest request);

    List<CropResponse> getAll();

    CropResponse getById(UUID cropId);

    CropResponse update(UUID cropId, CropRequest request);

    void delete(UUID cropId);
}