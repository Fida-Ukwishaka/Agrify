package org.example.agrify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.agrify.dto.request.WorkerRequest;
import org.example.agrify.dto.response.WorkerResponse;
import org.example.agrify.entity.Farm;
import org.example.agrify.entity.Worker;
import org.example.agrify.exception.ResourceNotFoundException;
import org.example.agrify.mapper.WorkerMapper;
import org.example.agrify.repository.FarmRepository;
import org.example.agrify.repository.WorkerRepository;
import org.example.agrify.service.interfaces.WorkerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final PasswordEncoder passwordEncoder;

    private final WorkerRepository workerRepository;
    private final FarmRepository farmRepository;
    private final WorkerMapper workerMapper;

    @Override
    public WorkerResponse create(WorkerRequest request) {

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        Worker worker = workerMapper.toEntity(request);

        worker.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        worker.setFarm(farm);

        Worker savedWorker = workerRepository.save(worker);

        return workerMapper.toResponse(savedWorker);
    }

    @Override
    public List<WorkerResponse> getAll() {

        return workerRepository.findAll()
                .stream()
                .map(workerMapper::toResponse)
                .toList();
    }

    @Override
    public WorkerResponse getById(UUID workerId) {

        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not found"));

        return workerMapper.toResponse(worker);
    }

    @Override
    public WorkerResponse update(UUID workerId, WorkerRequest request) {

        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not found"));

        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        workerMapper.updateEntity(request, worker);
        worker.setFarm(farm);

        Worker updatedWorker = workerRepository.save(worker);

        return workerMapper.toResponse(updatedWorker);
    }

    @Override
    public void delete(UUID workerId) {

        if (!workerRepository.existsById(workerId)) {
            throw new ResourceNotFoundException("Worker not found");
        }

        workerRepository.deleteById(workerId);
    }
}