package org.example.agrify.mapper;

import org.example.agrify.dto.request.CustomerRequest;
import org.example.agrify.dto.response.CustomerResponse;
import org.example.agrify.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequest request);

    CustomerResponse toResponse(Customer customer);

    void updateEntity(CustomerRequest request,
                      @MappingTarget Customer customer);
}