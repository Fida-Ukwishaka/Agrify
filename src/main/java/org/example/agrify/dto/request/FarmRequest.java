package org.example.agrify.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmRequest {

    @NotBlank(message = "Farm name is required")
    private String farmName;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Farm size is required")
    @DecimalMin(value = "0.1", message = "Farm size must be greater than zero")
    private BigDecimal farmSize;

    @NotBlank(message = "Owner name is required")
    private String ownerName;
}