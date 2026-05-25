package com.obada.gym_management_system.repository;


import com.obada.gym_management_system.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findTopByTraineeIdOrderByJoinedDateDesc(Long traineeId);
}
