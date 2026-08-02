package org.example.agrify.mapper;


import org.example.agrify.dto.request.CropRequest;
import org.example.agrify.dto.response.CropResponse;
import org.example.agrify.entity.Crop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CropMapper {

    @Mapping(target = "cropId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    Crop toEntity(CropRequest request);

    @Mapping(source = "farm.farmId", target = "farmId")
    CropResponse toResponse(Crop crop);

    @Mapping(target = "cropId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    void updateEntity(CropRequest request, @MappingTarget Crop crop);
}
