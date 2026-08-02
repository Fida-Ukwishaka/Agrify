package org.example.agrify.mapper;

import org.example.agrify.dto.request.WorkerRequest;
import org.example.agrify.dto.response.WorkerResponse;
import org.example.agrify.entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    @Mapping(target = "workerId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "checkInTime", ignore = true)
    @Mapping(target = "checkOutTime", ignore = true)
    Worker toEntity(WorkerRequest request);

    @Mapping(source = "farm.farmId", target = "farmId")
    WorkerResponse toResponse(Worker worker);

    @Mapping(target = "workerId", ignore = true)
    @Mapping(target = "farm", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "checkInTime", ignore = true)
    @Mapping(target = "checkOutTime", ignore = true)
    void updateEntity(WorkerRequest request, @MappingTarget Worker worker);
}