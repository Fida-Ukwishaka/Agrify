package org.example.agrify.mapper;

import org.example.agrify.dto.request.HarvestRequest;
import org.example.agrify.dto.response.HarvestResponse;
import org.example.agrify.entity.Harvest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HarvestMapper {

    @Mapping(target = "harvestId", ignore = true)
    @Mapping(target = "crop", ignore = true)
    Harvest toEntity(HarvestRequest request);

    @Mapping(source = "crop.cropId", target = "cropId")
    HarvestResponse toResponse(Harvest harvest);

    @Mapping(target = "harvestId", ignore = true)
    @Mapping(target = "crop", ignore = true)
    void updateEntity(HarvestRequest request, @MappingTarget Harvest harvest);
}