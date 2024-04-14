package com.networking.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;


@Table("customers")
public record LearnerEntity(
        @Id Long id,
        String email,
        String password,
        boolean enabled,
        String firstName,
        String lastName

//        Date registerDate,
//
//        Date lastLogin,
//
//        List<String> finishedTopics,
//
//        List<String> ongoingTopics,
//
//        Double accuracyRate

) {
}
