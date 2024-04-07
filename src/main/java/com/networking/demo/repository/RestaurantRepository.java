package com.networking.demo.repository;


import com.networking.demo.entity.PlatformEntity;
import org.springframework.data.repository.ListCrudRepository;


public interface RestaurantRepository extends ListCrudRepository<PlatformEntity, Long> {
}
