package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.FertilizerRequest;
import org.example.agrify.dto.response.FertilizerResponse;
import org.example.agrify.entity.Farm;
import org.example.agrify.entity.Fertilizer;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.FertilizerMapper;
import org.example.agrify.repository.FarmRepository;
import org.example.agrify.repository.FertilizerRepository;
import org.example.agrify.service.interfaces.FertilizerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FertilizerServiceImpl implements FertilizerService {

    private final FertilizerRepository fertilizerRepository;
    private final FarmRepository farmRepository;
    private final FertilizerMapper fertilizerMapper;

    @Override
    public FertilizerResponse create(FertilizerRequest request) {

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        Fertilizer fertilizer = fertilizerMapper.toEntity(request);
        fertilizer.setFarm(farm);

        return fertilizerMapper.toResponse(
                fertilizerRepository.save(fertilizer)
        );
    }

    @Override
    public List<FertilizerResponse> getAll() {

        return fertilizerRepository.findAll()
                .stream()
                .map(fertilizerMapper::toResponse)
                .toList();
    }

    @Override
    public FertilizerResponse getById(UUID fertilizerId) {

        Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
                .orElseThrow(() -> new ResourceNotFoundException("Fertilizer not found"));

        return fertilizerMapper.toResponse(fertilizer);
    }

    @Override
    public FertilizerResponse update(UUID fertilizerId, FertilizerRequest request) {

        Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
                .orElseThrow(() -> new ResourceNotFoundException("Fertilizer not found"));

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        fertilizerMapper.updateEntity(request, fertilizer);
        fertilizer.setFarm(farm);

        return fertilizerMapper.toResponse(
                fertilizerRepository.save(fertilizer)
        );
    }

    @Override
    public void delete(UUID fertilizerId) {

        Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
                .orElseThrow(() -> new ResourceNotFoundException("Fertilizer not found"));

        fertilizerRepository.delete(fertilizer);
    }
}