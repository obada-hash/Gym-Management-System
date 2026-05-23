package com.obada.gym_management_system.controller;


import com.obada.gym_management_system.dto.CreateTraineeRequest;
import com.obada.gym_management_system.dto.TraineeDto;
import com.obada.gym_management_system.entity.Trainee;
import com.obada.gym_management_system.mapper.TraineeMapper;
import com.obada.gym_management_system.service.TraineeService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.ResponseEntity;
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
    private final TraineeMapper traineeMapper;



    @GetMapping
    public ResponseEntity<TraineeDto> findById(
            @RequestParam Long id
    ){
        // if admin return; else check if id is equal to the authenticated user
        TraineeDto dto = traineeMapper.toDto(traineeService.findById(id));
        return ResponseEntity.ok(dto);
    }




}
