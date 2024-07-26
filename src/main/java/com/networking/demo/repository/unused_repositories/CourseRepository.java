package com.networking.demo.repository.unused_repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.networking.demo.entity.unused_entities.CourseEntity;


public interface CourseRepository extends CrudRepository<CourseEntity, Long> {


    CourseEntity getByCustomerId(Long customerId);


    @Modifying
    @Query("UPDATE carts SET total_price = :totalPrice WHERE id = :cartId")
    void updateTotalPrice(Long cartId, Double totalPrice);
}
