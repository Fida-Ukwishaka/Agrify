package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "farms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "farm_id", nullable = false, updatable = false)
    private UUID farmId;

    @NotBlank(message = "Farm name is required")
    @Column(name = "farm_name", nullable = false)
    private String farmName;

    @NotBlank(message = "Location is required")
    @Column(nullable = false)
    private String location;

    @NotNull(message = "Farm size is required")
    @DecimalMin(value = "0.1", message = "Farm size must be greater than zero")
    @Column(name = "farm_size", nullable = false, precision = 10, scale = 2)
    private BigDecimal farmSize;

    @NotBlank(message = "Owner name is required")
    @Column(name = "owner_name", nullable = false)
    private String ownerName;
}