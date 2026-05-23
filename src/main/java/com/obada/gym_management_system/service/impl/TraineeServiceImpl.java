package com.obada.gym_management_system.service.impl;

import com.obada.gym_management_system.dto.CreateTraineeRequest;
import com.obada.gym_management_system.entity.AppUser;
import com.obada.gym_management_system.entity.Subscription;
import com.obada.gym_management_system.entity.Trainee;
import com.obada.gym_management_system.mapper.AppUserMapper;
import com.obada.gym_management_system.mapper.SubscriptionMapper;
import com.obada.gym_management_system.repository.TraineeRepo;
import com.obada.gym_management_system.service.AppUserService;
import com.obada.gym_management_system.service.SubscriptionService;
import com.obada.gym_management_system.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraineeServiceImpl implements TraineeService {


    private final AppUserService appUserService;
    private final SubscriptionService subscriptionService;
    private final AppUserMapper appUserMapper;
    private final SubscriptionMapper subscriptionMapper;
    private final TraineeRepo traineeRepo;


    @Override
    public Trainee saveTrainee(CreateTraineeRequest request) {

        AppUser appUser = appUserService.insert(request.getAppUser());

        Trainee trainee = Trainee.builder()
                .appUser(appUser)
                .build();
        trainee = traineeRepo.save(trainee);

        Subscription subscription = subscriptionMapper.toEntity(request.getSubscription());
        subscription.setTrainee(trainee);
        subscriptionService.insert(subscription);

        return trainee;

    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepo.findAll();
    }

    @Override
    public Trainee findById(Long id) {
        return traineeRepo.findById(id).orElse(null);
    }
}
