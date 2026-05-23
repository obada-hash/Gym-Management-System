package com.obada.gym_management_system.repository;

import com.obada.gym_management_system.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {


    Optional<AppUser> findByEmail(String email);


}
