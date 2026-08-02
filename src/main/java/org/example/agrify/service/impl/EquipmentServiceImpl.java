package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.EquipmentRequest;
import org.example.agrify.dto.response.EquipmentResponse;
import org.example.agrify.entity.Equipment;
import org.example.agrify.entity.Farm;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.EquipmentMapper;
import org.example.agrify.repository.EquipmentRepository;
import org.example.agrify.repository.FarmRepository;
import org.example.agrify.service.interfaces.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final FarmRepository farmRepository;
    private final EquipmentMapper equipmentMapper;

    @Override
    public EquipmentResponse create(EquipmentRequest request) {

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        Equipment equipment = equipmentMapper.toEntity(request);
        equipment.setFarm(farm);

        return equipmentMapper.toResponse(
                equipmentRepository.save(equipment)
        );
    }

    @Override
    public List<EquipmentResponse> getAll() {

        return equipmentRepository.findAll()
                .stream()
                .map(equipmentMapper::toResponse)
                .toList();
    }

    @Override
    public EquipmentResponse getById(UUID equipmentId) {

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));

        return equipmentMapper.toResponse(equipment);
    }

    @Override
    public EquipmentResponse update(UUID equipmentId, EquipmentRequest request) {

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        equipmentMapper.updateEntity(request, equipment);
        equipment.setFarm(farm);

        return equipmentMapper.toResponse(
                equipmentRepository.save(equipment)
        );
    }

    @Override
    public void delete(UUID equipmentId) {

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));

        equipmentRepository.delete(equipment);
    }
}