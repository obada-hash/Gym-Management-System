package com.obada.gym_management_system.controller;


import com.obada.gym_management_system.dto.CreateTraineeRequest;
import com.obada.gym_management_system.dto.TraineeDto;
import com.obada.gym_management_system.entity.Trainee;
import com.obada.gym_management_system.mapper.TraineeMapper;
import com.obada.gym_management_system.service.AdminService;
import com.obada.gym_management_system.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final TraineeService traineeService;
    private final TraineeMapper traineeMapper;


    @PostMapping
    public ResponseEntity<TraineeDto> insertTrainee(
            @RequestBody CreateTraineeRequest request) {

        Trainee trainee = traineeService.saveTrainee(request);
        TraineeDto traineeDto = traineeMapper.toDto(trainee);
        return ResponseEntity.ok(traineeDto);

    }

    @GetMapping
    public ResponseEntity<List<TraineeDto>> getAllTrainees() {
        List<TraineeDto> list = traineeService.getAllTrainees().stream()
                .map(traineeMapper::toDto)
                .toList();
        return ResponseEntity.ok(list);
    }



}
