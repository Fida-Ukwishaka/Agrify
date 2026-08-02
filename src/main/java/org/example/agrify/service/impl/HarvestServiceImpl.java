package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.HarvestRequest;
import org.example.agrify.dto.response.HarvestResponse;
import org.example.agrify.entity.Crop;
import org.example.agrify.entity.Harvest;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.HarvestMapper;
import org.example.agrify.repository.CropRepository;
import org.example.agrify.repository.HarvestRepository;
import org.example.agrify.service.interfaces.HarvestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HarvestServiceImpl implements HarvestService {

    private final HarvestRepository harvestRepository;
    private final CropRepository cropRepository;
    private final HarvestMapper harvestMapper;

    @Override
    public HarvestResponse create(HarvestRequest request) {

        Crop crop = cropRepository.findById(request.getCropId())
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found"));

        Harvest harvest = harvestMapper.toEntity(request);
        harvest.setCrop(crop);

        return harvestMapper.toResponse(harvestRepository.save(harvest));
    }

    @Override
    public List<HarvestResponse> getAll() {

        return harvestRepository.findAll()
                .stream()
                .map(harvestMapper::toResponse)
                .toList();
    }

    @Override
    public HarvestResponse getById(UUID harvestId) {

        Harvest harvest = harvestRepository.findById(harvestId)
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found"));

        return harvestMapper.toResponse(harvest);
    }

    @Override
    public HarvestResponse update(UUID harvestId, HarvestRequest request) {

        Harvest harvest = harvestRepository.findById(harvestId)
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found"));

        Crop crop = cropRepository.findById(request.getCropId())
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found"));

        harvestMapper.updateEntity(request, harvest);
        harvest.setCrop(crop);

        return harvestMapper.toResponse(harvestRepository.save(harvest));
    }

    @Override
    public void delete(UUID harvestId) {

        Harvest harvest = harvestRepository.findById(harvestId)
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found"));

        harvestRepository.delete(harvest);
    }
}