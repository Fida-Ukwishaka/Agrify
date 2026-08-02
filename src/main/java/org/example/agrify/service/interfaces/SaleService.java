package org.example.agrify.service.interfaces;

import org.example.agrify.dto.request.SaleRequest;
import org.example.agrify.dto.response.SaleResponse;

import java.util.List;
import java.util.UUID;

public interface SaleService {

    SaleResponse create(SaleRequest request);

    List<SaleResponse> getAll();

    SaleResponse getById(UUID saleId);

    SaleResponse update(UUID saleId, SaleRequest request);

    void delete(UUID saleId);
}