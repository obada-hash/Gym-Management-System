package com.obada.gym_management_system.mapper;

import com.obada.gym_management_system.dto.AppUserDto;
import com.obada.gym_management_system.dto.CreateAppUserRequest;
import com.obada.gym_management_system.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserMapper {


    AppUser toEntity(CreateAppUserRequest request);

    AppUserDto toDto(AppUser entity);
}
