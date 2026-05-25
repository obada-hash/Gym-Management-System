package com.obada.gym_management_system.config;


import com.obada.gym_management_system.dto.CreateAppUserRequest;
import com.obada.gym_management_system.entity.Admin;
import com.obada.gym_management_system.entity.AppUser;
import com.obada.gym_management_system.entity.Role;
import com.obada.gym_management_system.repository.AdminRepo;
import com.obada.gym_management_system.repository.AppUserRepo;
import com.obada.gym_management_system.service.AdminService;
import com.obada.gym_management_system.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartUpConfig implements CommandLineRunner {

    private final AdminRepo adminRepo;
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if(adminRepo.findAll().isEmpty()){

            AppUser appUser = AppUser.builder()
                    .firstName("admin")
                    .middleName("admin")
                    .lastName("admin")
                    .password(passwordEncoder.encode("admin"))
                    .email("Admin@email.com")
                    .role(Role.ADMIN)
                    .build();

            appUser = appUserRepo.save(appUser);

            Admin admin = Admin.builder()
                    .appUser(appUser)
                    .build();

            admin = adminRepo.save(admin);

            System.out.println("admin created yayyy");
        }

    }
}
