package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.FertilizerType;
import org.example.agrify.enums.Unit;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "fertilizers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "fertilizer_id", nullable = false, updatable = false)
    private UUID fertilizerId;

    @NotBlank(message = "Fertilizer name is required")
    @Column(nullable = false)
    private String fertilizerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FertilizerType fertilizerType;

    @NotNull(message = "Quantity is required")
    @Column(nullable = false)
    private Double quantityAvailable;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Unit unit;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;

    @NotBlank(message = "Supplier is required")
    @Column(nullable = false)
    private String supplier;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;
}