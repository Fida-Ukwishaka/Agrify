package org.example.agrify.mapper;

import org.example.agrify.dto.request.FertilizerRequest;
import org.example.agrify.dto.response.FertilizerResponse;
import org.example.agrify.entity.Fertilizer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FertilizerMapper {

    @Mapping(target = "fertilizerId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    Fertilizer toEntity(FertilizerRequest request);

    @Mapping(source = "farm.farmId", target = "farmId")
    FertilizerResponse toResponse(Fertilizer fertilizer);

    @Mapping(target = "fertilizerId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    void updateEntity(FertilizerRequest request, @MappingTarget Fertilizer fertilizer);
}