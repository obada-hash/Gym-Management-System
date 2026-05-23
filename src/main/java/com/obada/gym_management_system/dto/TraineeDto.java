package com.obada.gym_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TraineeDto {


    private Long id;
    private List<SubscriptionDto> subscriptionDto;
    private AppUserDto appUserDto;
}
