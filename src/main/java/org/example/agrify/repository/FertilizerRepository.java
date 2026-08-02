package org.example.agrify.repository;

import org.example.agrify.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, UUID> {
}