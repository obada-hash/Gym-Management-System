package com.obada.gym_management_system.dto;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTraineeRequest {

    @Valid
    private CreateSubscriptionRequest subscription;

    @Valid
    private CreateAppUserRequest appUser;

}
