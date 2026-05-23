package com.obada.gym_management_system.repository;

import com.obada.gym_management_system.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepo extends JpaRepository<Trainee, Long> {
}
