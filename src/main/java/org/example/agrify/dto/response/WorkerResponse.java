package org.example.agrify.dto.response;

import lombok.*;
import org.example.agrify.enums.Role;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkerResponse {

    private UUID workerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private BigDecimal salary;
    private Role role;
    private Boolean approved;
    private LocalDateTime createdAt;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private UUID farmId;
}