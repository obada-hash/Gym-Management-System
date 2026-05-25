package com.obada.gym_management_system.dto;

import com.obada.gym_management_system.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserDto {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private Role role;

    private LocalDate joinedDate;
}
