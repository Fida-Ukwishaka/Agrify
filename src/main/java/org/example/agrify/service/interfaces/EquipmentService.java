package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.EquipmentRequest;
import org.example.agrify.dto.response.EquipmentResponse;

import java.util.List;
import java.util.UUID;

public interface EquipmentService {

    EquipmentResponse create(EquipmentRequest request);

    List<EquipmentResponse> getAll();

    EquipmentResponse getById(UUID equipmentId);

    EquipmentResponse update(UUID equipmentId, EquipmentRequest request);

    void delete(UUID equipmentId);
}