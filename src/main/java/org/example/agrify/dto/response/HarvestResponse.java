package org.example.agrify.dto.response;

import lombok.*;
import org.example.agrify.enums.HarvestQuality;
import org.example.agrify.enums.Unit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HarvestResponse {

    private UUID harvestId;
    private LocalDate harvestDate;
    private BigDecimal quantityHarvested;
    private Unit unit;
    private HarvestQuality harvestQuality;
    private UUID cropId;
}
