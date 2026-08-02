package org.example.agrify.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.agrify.enums.Role;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkerRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phoneNumber;

    @NotNull
    private BigDecimal salary;

    @NotNull
    private Role role;

    @NotNull
    private UUID farmId;
}