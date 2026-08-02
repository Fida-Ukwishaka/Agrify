package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.FarmRequest;
import org.example.agrify.dto.response.FarmResponse;
import org.example.agrify.entity.Farm;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.FarmMapper;
import org.example.agrify.repository.FarmRepository;
import org.example.agrify.service.interfaces.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;

    @Override
    public FarmResponse create(FarmRequest request) {

        Farm farm = farmMapper.toEntity(request);

        Farm savedFarm = farmRepository.save(farm);

        return farmMapper.toResponse(savedFarm);
    }

    @Override
    public List<FarmResponse> getAll() {

        return farmRepository.findAll()
                .stream()
                .map(farmMapper::toResponse)
                .toList();
    }

    @Override
    public FarmResponse getById(UUID farmId) {

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        return farmMapper.toResponse(farm);
    }

    @Override
    public FarmResponse update(UUID farmId, FarmRequest request) {

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        farmMapper.updateEntity(request, farm);

        Farm updatedFarm = farmRepository.save(farm);

        return farmMapper.toResponse(updatedFarm);
    }

    @Override
    public void delete(UUID farmId) {

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        farmRepository.delete(farm);
    }
}