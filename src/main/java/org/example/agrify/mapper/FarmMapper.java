package org.example.agrify.mapper;

import org.example.agrify.dto.request.FarmRequest;
import org.example.agrify.dto.response.FarmResponse;
import org.example.agrify.entity.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    @Mapping(target = "farmId", ignore = true)
    Farm toEntity(FarmRequest request);

    FarmResponse toResponse(Farm farm);

    @Mapping(target = "farmId", ignore = true)
    void updateEntity(FarmRequest request, @MappingTarget Farm farm);
}