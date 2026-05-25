package com.obada.gym_management_system.controller;


import com.obada.gym_management_system.dto.CreateSubscriptionRequest;
import com.obada.gym_management_system.dto.CreateTraineeRequest;
import com.obada.gym_management_system.dto.SubscriptionDto;
import com.obada.gym_management_system.dto.TraineeDto;
import com.obada.gym_management_system.entity.Subscription;
import com.obada.gym_management_system.entity.Trainee;
import com.obada.gym_management_system.mapper.SubscriptionMapper;
import com.obada.gym_management_system.mapper.TraineeMapper;
import com.obada.gym_management_system.service.AdminService;
import com.obada.gym_management_system.service.SubscriptionService;
import com.obada.gym_management_system.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final TraineeService traineeService;
    private final TraineeMapper traineeMapper;
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;


    @PostMapping("trainee")
    public ResponseEntity<TraineeDto> insertTrainee(
            @RequestBody CreateTraineeRequest request) {

        Trainee trainee = traineeService.saveTrainee(request);
        TraineeDto traineeDto = traineeMapper.toDto(trainee);
        return ResponseEntity.ok(traineeDto);

    }

    @GetMapping("/trainee")
    public ResponseEntity<List<TraineeDto>> getAllTrainees() {
        List<TraineeDto> list = traineeService.getAllTrainees().stream()
                .map(traineeMapper::toDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/trainee/{id}")
    public ResponseEntity<TraineeDto> findById(
            @PathVariable Long id
    ){
        // if admin return; else check if id is equal to the authenticated user
        TraineeDto dto = traineeMapper.toDto(traineeService.findById(id));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/trainee/{email}")
    public ResponseEntity<TraineeDto> findById(
            @PathVariable String email
    ){
        TraineeDto dto = traineeMapper.toDto(traineeService.getTraineeByEmail(email));
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/trainee/{traineeId}/subscription")
    public ResponseEntity<SubscriptionDto> addSubscription(
            @RequestBody CreateSubscriptionRequest subRequest,
            @PathVariable Long traineeId
    ){
        Trainee trainee = traineeService.findById(traineeId);
        SubscriptionDto dto = subscriptionMapper.toDto(subscriptionService.addSubscription(subRequest, trainee));
        return ResponseEntity.ok(dto);
    }



}
