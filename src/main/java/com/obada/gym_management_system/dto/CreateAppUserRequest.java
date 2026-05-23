package com.obada.gym_management_system.dto;

import com.obada.gym_management_system.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAppUserRequest {


    @NotBlank(message = "first name must be provided")
    @Length(min = 3, max = 20, message = "first name must be between ${min} & ${max}")
    private String firstName;

    @NotBlank(message = "middle name must be provided")
    @Length(min = 3, max = 20, message = "mid name must be between ${min} & ${max}")
    private String middleName;

    @NotBlank(message = "last name must be provided")
    @Length(min = 3, max = 20, message = "last name must be between ${min} & ${max}")
    private String lastName;

    @NotBlank(message = "email name must be provided")
    @Email(message = "not a valid email")
    private String email;

    @NotBlank(message = "password name must be provided")
    @Length(min = 3, max = 20, message = "pass must be between ${min} & ${max}")
    private String password;
}
