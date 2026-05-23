package com.obada.gym_management_system.mapper;

import com.obada.gym_management_system.dto.CreateTraineeRequest;
import com.obada.gym_management_system.dto.TraineeDto;
import com.obada.gym_management_system.entity.AppUser;
import com.obada.gym_management_system.entity.Trainee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
 uses = {SubscriptionMapper.class, AppUserMapper.class})
public interface TraineeMapper {

    @Mapping(target = "appUserDto", source = "appUser")
    @Mapping(target = "subscriptionDto", source = "subscriptions")
    TraineeDto toDto(Trainee trainee);


}
