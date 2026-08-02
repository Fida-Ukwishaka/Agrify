package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.CropRequest;
import org.example.agrify.dto.response.CropResponse;
import org.example.agrify.entity.Crop;
import org.example.agrify.entity.Farm;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.CropMapper;
import org.example.agrify.repository.CropRepository;
import org.example.agrify.repository.FarmRepository;
import org.example.agrify.service.interfaces.CropService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;
    private final FarmRepository farmRepository;
    private final CropMapper cropMapper;

    @Override
    public CropResponse create(CropRequest request) {

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        Crop crop = cropMapper.toEntity(request);
        crop.setFarm(farm);

        Crop savedCrop = cropRepository.save(crop);

        return cropMapper.toResponse(savedCrop);
    }

    @Override
    public List<CropResponse> getAll() {

        return cropRepository.findAll()
                .stream()
                .map(cropMapper::toResponse)
                .toList();
    }

    @Override
    public CropResponse getById(UUID cropId) {

        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found"));

        return cropMapper.toResponse(crop);
    }

    @Override
    public CropResponse update(UUID cropId, CropRequest request) {

        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found"));

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        cropMapper.updateEntity(request, crop);
        crop.setFarm(farm);

        Crop updatedCrop = cropRepository.save(crop);

        return cropMapper.toResponse(updatedCrop);
    }

    @Override
    public void delete(UUID cropId) {

        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found"));

        cropRepository.delete(crop);
    }
}