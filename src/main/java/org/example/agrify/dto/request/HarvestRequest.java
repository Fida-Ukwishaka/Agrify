package org.example.agrify.dto.request;

import jakarta.validation.constraints.NotNull;
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
public class HarvestRequest {

    @NotNull
    private LocalDate harvestDate;

    @NotNull
    private BigDecimal quantityHarvested;

    @NotNull
    private Unit unit;

    @NotNull
    private HarvestQuality harvestQuality;

    @NotNull
    private UUID cropId;
}
