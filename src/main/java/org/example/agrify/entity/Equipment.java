package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.agrify.enums.EquipmentStatus;
import org.example.agrify.enums.EquipmentType;

import java.util.UUID;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "equipment_id", nullable = false, updatable = false)
    private UUID equipmentId;

    @NotBlank(message = "Equipment name is required")
    @Column(nullable = false)
    private String equipmentName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EquipmentType equipmentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EquipmentStatus equipmentStatus;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;
}