package org.example.agrify.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.EquipmentStatus;
import org.example.agrify.enums.EquipmentType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentRequest {

    @NotBlank
    private String equipmentName;

    @NotNull
    private EquipmentType equipmentType;

    @NotNull
    private EquipmentStatus equipmentStatus;

    @NotNull
    private UUID farmId;
}
