package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.GrowthStatus;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "crops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "crop_id", nullable = false, updatable = false)
    private UUID cropId;

    @NotBlank(message = "Crop name is required")
    @Column(nullable = false)
    private String cropName;

    @NotBlank(message = "Crop type is required")
    @Column(nullable = false)
    private String cropType;

    @NotNull(message = "Planting date is required")
    @Column(nullable = false)
    private LocalDate plantingDate;

    @NotNull(message = "Expected harvest date is required")
    @Column(nullable = false)
    private LocalDate expectedHarvestDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GrowthStatus growthStatus;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;
}