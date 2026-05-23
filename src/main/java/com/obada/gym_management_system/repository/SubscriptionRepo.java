package com.obada.gym_management_system.repository;


import com.obada.gym_management_system.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
}
