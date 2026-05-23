package com.obada.gym_management_system.mapper;


import com.obada.gym_management_system.dto.CreateSubscriptionRequest;
import com.obada.gym_management_system.dto.SubscriptionDto;
import com.obada.gym_management_system.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {

    Subscription toEntity(CreateSubscriptionRequest request);

    @Mapping(target = "expiryDate", source = "subscription", qualifiedByName = "setExpiryDate")
    @Mapping(target = "isActive", source = "subscription", qualifiedByName = "setIsActive")
    SubscriptionDto toDto(Subscription subscription);

    @Named("setExpiryDate")
    default LocalDate setExpiryDate(Subscription subscription) {
        return subscription.getJoinedDate().plusDays(subscription.getSubscriptionDurationInDays());
    }

    @Named("setIsActive")
    default Boolean setIsActive(Subscription subscription) {
        LocalDate expiryDate = subscription.getJoinedDate().plusDays(subscription.getSubscriptionDurationInDays());
        return expiryDate.isEqual(LocalDate.now()) ||
                expiryDate.isAfter(LocalDate.now());
    }
}
