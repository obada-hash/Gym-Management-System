package com.obada.gym_management_system.security;

import com.obada.gym_management_system.entity.AppUser;
import com.obada.gym_management_system.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser appUser = appUserRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(appUser.getEmail())
                .password(appUser.getPassword())
                .authorities(new SimpleGrantedAuthority(appUser.getRole().name()))
                .build();
    }
}
