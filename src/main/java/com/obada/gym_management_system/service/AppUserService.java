package com.obada.gym_management_system.service;

import com.obada.gym_management_system.dto.CreateAppUserRequest;
import com.obada.gym_management_system.entity.AppUser;

public interface AppUserService {


    AppUser insert(CreateAppUserRequest createAppUserRequest);

    AppUser getById(Long id);

}
