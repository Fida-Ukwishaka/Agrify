package org.example.agrify.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmResponse {

    private UUID farmId;
    private String farmName;
    private String location;
    private BigDecimal farmSize;
    private String ownerName;
}