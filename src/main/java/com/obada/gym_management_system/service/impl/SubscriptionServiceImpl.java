package com.obada.gym_management_system.service.impl;


import com.obada.gym_management_system.dto.CreateSubscriptionRequest;
import com.obada.gym_management_system.entity.Subscription;
import com.obada.gym_management_system.mapper.SubscriptionMapper;
import com.obada.gym_management_system.repository.SubscriptionRepo;
import com.obada.gym_management_system.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;
    private final SubscriptionMapper subscriptionMapper;


    @Override
    public Subscription insert(Subscription subscription) {
        return subscriptionRepo.save(subscription);
    }

    @Override
    public Subscription findById(long id) {
        return subscriptionRepo.findById(id).orElse(null);
    }
}
