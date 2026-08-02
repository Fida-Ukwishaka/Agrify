package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.SaleRequest;
import org.example.agrify.dto.response.SaleResponse;
import org.example.agrify.entity.Customer;
import org.example.agrify.entity.Harvest;
import org.example.agrify.entity.Sale;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.SaleMapper;
import org.example.agrify.repository.CustomerRepository;
import org.example.agrify.repository.HarvestRepository;
import org.example.agrify.repository.SaleRepository;
import org.example.agrify.service.interfaces.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final HarvestRepository harvestRepository;
    private final CustomerRepository customerRepository;
    private final SaleMapper saleMapper;

    @Override
    public SaleResponse create(SaleRequest request) {

        Harvest harvest = harvestRepository.findById(request.getHarvestId())
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Sale sale = saleMapper.toEntity(request);
        sale.setHarvest(harvest);
        sale.setCustomer(customer);

        return saleMapper.toResponse(saleRepository.save(sale));
    }

    @Override
    public List<SaleResponse> getAll() {

        return saleRepository.findAll()
                .stream()
                .map(saleMapper::toResponse)
                .toList();
    }

    @Override
    public SaleResponse getById(UUID saleId) {

        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        return saleMapper.toResponse(sale);
    }

    @Override
    public SaleResponse update(UUID saleId, SaleRequest request) {

        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        Harvest harvest = harvestRepository.findById(request.getHarvestId())
                .orElseThrow(() -> new ResourceNotFoundException("Harvest not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        saleMapper.updateEntity(request, sale);
        sale.setHarvest(harvest);
        sale.setCustomer(customer);

        return saleMapper.toResponse(saleRepository.save(sale));
    }

    @Override
    public void delete(UUID saleId) {

        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        saleRepository.delete(sale);
    }
}