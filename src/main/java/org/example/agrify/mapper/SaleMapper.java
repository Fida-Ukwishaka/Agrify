package org.example.agrify.mapper;

import org.example.agrify.dto.request.SaleRequest;
import org.example.agrify.dto.response.SaleResponse;
import org.example.agrify.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "saleId", ignore = true)
    @Mapping(target = "harvest", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Sale toEntity(SaleRequest request);

    @Mapping(source = "harvest.harvestId", target = "harvestId")
    @Mapping(source = "customer.customerId", target = "customerId")
    SaleResponse toResponse(Sale sale);

    @Mapping(target = "saleId", ignore = true)
    @Mapping(target = "harvest", ignore = true)
    @Mapping(target = "customer", ignore = true)
    void updateEntity(SaleRequest request,
                      @MappingTarget Sale sale);
}