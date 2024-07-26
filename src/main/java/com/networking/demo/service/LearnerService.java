package com.networking.demo.service;


import com.networking.demo.entity.LearnerEntity;
import com.networking.demo.entity.unused_entities.CourseEntity;
import com.networking.demo.repository.LearnerRepository;
import com.networking.demo.repository.unused_repositories.CourseRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LearnerService {


    private final CourseRepository courseRepository;
    private final LearnerRepository learnerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsManager userDetailsManager;


    public LearnerService(
            CourseRepository courseRepository,
            LearnerRepository learnerRepository,
            PasswordEncoder passwordEncoder,
            UserDetailsManager userDetailsManager) {
        this.courseRepository = courseRepository;
        this.learnerRepository = learnerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsManager = userDetailsManager;
    }


    @Transactional
    public void signUp(String email, String password, String firstName, String lastName) {
        email = email.toLowerCase();
        UserDetails user = User.builder()
                .username(email)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);
        learnerRepository.updateNameByEmail(email, firstName, lastName);


        LearnerEntity savedCustomer = learnerRepository.findByEmail(email);
        CourseEntity cart = new CourseEntity(null, savedCustomer.id(), 0.0);
        courseRepository.save(cart);
    }


    public LearnerEntity getCustomerByEmail(String email) {
        return learnerRepository.findByEmail(email);
    }
}
