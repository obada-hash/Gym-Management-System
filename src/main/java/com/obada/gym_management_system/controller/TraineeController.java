package com.obada.gym_management_system.controller;


import com.obada.gym_management_system.dto.SubscriptionDto;
import com.obada.gym_management_system.dto.TraineeDto;
import com.obada.gym_management_system.entity.Subscription;
import com.obada.gym_management_system.entity.Trainee;
import com.obada.gym_management_system.mapper.SubscriptionMapper;
import com.obada.gym_management_system.mapper.TraineeMapper;
import com.obada.gym_management_system.service.SubscriptionService;
import com.obada.gym_management_system.service.TraineeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("api/v1/trainee")
public class TraineeController {

    private final TraineeService traineeService;
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;
    private final TraineeMapper traineeMapper;



    @GetMapping("/me")
    public ResponseEntity<TraineeDto> getCurrentTrainee(
            Authentication auth
    ) {

        String email = auth.getName();
        Trainee trainee = traineeService.getTraineeByEmail(email);
        TraineeDto dto = traineeMapper.toDto(trainee);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/lastsub/{traineeId}")
    public ResponseEntity<SubscriptionDto> getLatestSubscriptionByTraineeId(
            @PathVariable Long traineeId,
            Authentication auth) {

        boolean isAdmin = auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"));
        boolean isOwner = traineeService.getTraineeByEmail(auth.getName()).getId().equals(traineeId);

        if (isAdmin || isOwner) {
            Subscription subscription = subscriptionService.getLatestSubscriptionByTraineeId(traineeId);
            SubscriptionDto dto = subscriptionMapper.toDto(subscription);
            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }






}
