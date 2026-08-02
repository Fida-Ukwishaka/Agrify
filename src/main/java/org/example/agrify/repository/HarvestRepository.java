package org.example.agrify.repository;

import org.example.agrify.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, UUID> {
}