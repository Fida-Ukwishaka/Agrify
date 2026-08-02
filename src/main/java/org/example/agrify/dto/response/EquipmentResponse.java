package org.example.agrify.dto.response;

import lombok.*;
import org.example.agrify.enums.EquipmentStatus;
import org.example.agrify.enums.EquipmentType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentResponse {

    private UUID equipmentId;
    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;
    private UUID farmId;
}
