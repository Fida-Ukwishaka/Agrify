package org.example.agrify.repository;

import org.example.agrify.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {

    Optional<Worker> findByEmail(String email);

}