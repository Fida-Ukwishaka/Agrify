package org.example.agrify.mapper;

import org.example.agrify.dto.request.EquipmentRequest;
import org.example.agrify.dto.response.EquipmentResponse;
import org.example.agrify.entity.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {

    @Mapping(target = "equipmentId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    Equipment toEntity(EquipmentRequest request);

    @Mapping(source = "farm.farmId", target = "farmId")
    EquipmentResponse toResponse(Equipment equipment);

    @Mapping(target = "equipmentId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    void updateEntity(EquipmentRequest request, @MappingTarget Equipment equipment);
}