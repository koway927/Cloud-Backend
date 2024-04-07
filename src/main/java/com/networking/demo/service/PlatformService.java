package com.networking.demo.service;


import com.networking.demo.entity.MenuItemEntity;
import com.networking.demo.entity.PlatformEntity;
import com.networking.demo.model.MenuItemDto;
import com.networking.demo.model.PlatformDto;
import com.networking.demo.repository.MenuItemRepository;
import com.networking.demo.repository.RestaurantRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PlatformService {


    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;


    public PlatformService(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Cacheable("restaurants")
    public List<PlatformDto> getRestaurants() {
        List<PlatformEntity> restaurantEntities = restaurantRepository.findAll();
        List<MenuItemEntity> menuItemEntities = menuItemRepository.findAll();
        Map<Long, List<MenuItemDto>> groupedMenuItems = new HashMap<>();
        for (MenuItemEntity menuItemEntity : menuItemEntities) {
            List<MenuItemDto> group = groupedMenuItems.computeIfAbsent(menuItemEntity.restaurantId(), k -> new ArrayList<>());
            MenuItemDto menuItemDto = new MenuItemDto(menuItemEntity);
            group.add(menuItemDto);
        }
        List<PlatformDto> results = new ArrayList<>();
        for (PlatformEntity platformEntity : restaurantEntities) {
            PlatformDto platformDto = new PlatformDto(platformEntity, groupedMenuItems.get(platformEntity.id()));
            results.add(platformDto);
        }
        return results;
    }



}
