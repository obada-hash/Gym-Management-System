package com.obada.gym_management_system.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSubscriptionRequest {

    @Builder.Default
    private Integer subscriptionDurationInDays = 0;

}
