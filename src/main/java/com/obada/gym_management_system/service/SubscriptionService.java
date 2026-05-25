package com.obada.gym_management_system.service;

import com.obada.gym_management_system.dto.CreateSubscriptionRequest;
import com.obada.gym_management_system.entity.Subscription;

public interface SubscriptionService {


     Subscription insert(Subscription subscription);

     Subscription findById(long id);

     Subscription addSubscription(CreateSubscriptionRequest request, Long traineeId);

     Subscription getLatestSubscriptionByTraineeId(Long traineeId);


}
