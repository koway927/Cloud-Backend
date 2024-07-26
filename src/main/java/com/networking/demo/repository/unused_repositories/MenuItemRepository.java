package com.networking.demo.repository.unused_repositories;


import org.springframework.data.repository.ListCrudRepository;

import com.networking.demo.entity.unused_entities.MenuItemEntity;

import java.util.List;


public interface MenuItemRepository extends ListCrudRepository<MenuItemEntity, Long> {


    List<MenuItemEntity> getByRestaurantId(Long restaurantId);
}
