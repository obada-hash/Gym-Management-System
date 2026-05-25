package com.obada.gym_management_system.service;

import com.obada.gym_management_system.dto.CreateSubscriptionRequest;
import com.obada.gym_management_system.entity.Subscription;
import com.obada.gym_management_system.entity.Trainee;

public interface SubscriptionService {


     Subscription insert(Subscription subscription);

     Subscription findById(long id);

     Subscription addSubscription(CreateSubscriptionRequest request, Trainee trainee);

     Subscription getLatestSubscriptionByTraineeId(Long traineeId);


}
