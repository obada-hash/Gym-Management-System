package com.obada.gym_management_system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trainees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "trainee", fetch =  FetchType.EAGER)
    private List<Subscription> subscriptions;

    @OneToOne
    private AppUser appUser;



}
