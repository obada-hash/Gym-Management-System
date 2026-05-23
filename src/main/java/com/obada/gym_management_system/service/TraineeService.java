package com.obada.gym_management_system.service;

import com.obada.gym_management_system.dto.CreateTraineeRequest;
import com.obada.gym_management_system.entity.Trainee;

import java.util.List;

public interface TraineeService {


    Trainee saveTrainee(CreateTraineeRequest request);

    List<Trainee> getAllTrainees();

    Trainee findById(Long id);
}
