package com.networking.demo.repository;


import com.networking.demo.entity.LearnerEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;


public interface CustomerRepository extends ListCrudRepository<LearnerEntity, Long> {


    List<LearnerEntity> findByFirstName(String firstName);


    List<LearnerEntity> findByLastName(String lastName);


    LearnerEntity findByEmail(String email);


    @Modifying
    @Query("UPDATE customers SET first_name = :firstName, last_name = :lastName WHERE id = :id")
    void updateNameById(long id, String firstName, String lastName);


    @Modifying
    @Query("UPDATE customers SET first_name = :firstName, last_name = :lastName WHERE email = :email")
    void updateNameByEmail(String email, String firstName, String lastName);
}
