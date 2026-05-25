package com.obada.gym_management_system.service.impl;


import com.obada.gym_management_system.dto.CreateAppUserRequest;
import com.obada.gym_management_system.entity.AppUser;
import com.obada.gym_management_system.entity.Role;
import com.obada.gym_management_system.mapper.AppUserMapper;
import com.obada.gym_management_system.repository.AppUserRepo;
import com.obada.gym_management_system.service.AppUserService;
import io.jsonwebtoken.security.Password;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {


    private final AppUserMapper appUserMapper;
    private AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AppUser insert(CreateAppUserRequest createAppUserRequest) {
        AppUser appUser = appUserMapper.toEntity(createAppUserRequest);
        appUser.setRole(Role.TRAINEE);
        appUser.setPassword(passwordEncoder.encode(createAppUserRequest.getPassword()));
        return appUserRepo.save(appUser);
    }

    @Override
    public AppUser getById(Long id) {
        return appUserRepo.findById(id).orElse(null);
    }
}
