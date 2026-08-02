package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.HarvestQuality;
import org.example.agrify.enums.Unit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "harvests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Harvest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "harvest_id", nullable = false, updatable = false)
    private UUID harvestId;

    @NotNull(message = "Harvest date is required")
    @Column(nullable = false)
    private LocalDate harvestDate;

    @NotNull(message = "Quantity harvested is required")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantityHarvested;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Unit unit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HarvestQuality harvestQuality;

    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;
}