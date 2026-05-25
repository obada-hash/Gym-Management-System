package com.obada.gym_management_system.service.impl;

import com.obada.gym_management_system.entity.Admin;
import com.obada.gym_management_system.repository.AdminRepo;
import com.obada.gym_management_system.service.AdminService;
import com.obada.gym_management_system.service.TraineeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;
    private final TraineeService traineeService;


}
