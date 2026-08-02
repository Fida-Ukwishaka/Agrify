package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.HarvestRequest;
import org.example.agrify.dto.response.HarvestResponse;

import java.util.List;
import java.util.UUID;

public interface HarvestService {

    HarvestResponse create(HarvestRequest request);

    List<HarvestResponse> getAll();

    HarvestResponse getById(UUID harvestId);

    HarvestResponse update(UUID harvestId, HarvestRequest request);

    void delete(UUID harvestId);
}