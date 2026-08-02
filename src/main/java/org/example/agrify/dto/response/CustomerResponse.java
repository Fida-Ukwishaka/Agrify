package org.example.agrify.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private UUID customerId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String address;
}