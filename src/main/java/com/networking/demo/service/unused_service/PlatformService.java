package com.networking.demo.service.unused_service;


import com.networking.demo.entity.unused_entities.MenuItemEntity;
import com.networking.demo.entity.unused_entities.PlatformEntity;
import com.networking.demo.model.unused_models.MenuItemDto;
import com.networking.demo.model.unused_models.PlatformDto;
import com.networking.demo.repository.unused_repositories.MenuItemRepository;
import com.networking.demo.repository.unused_repositories.PlatformRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PlatformService {


    private final MenuItemRepository menuItemRepository;
    private final PlatformRepository platformRepository;


    public PlatformService(MenuItemRepository menuItemRepository, PlatformRepository platformRepository) {
        this.menuItemRepository = menuItemRepository;
        this.platformRepository = platformRepository;
    }

    @Cacheable("restaurants")
    public List<PlatformDto> getRestaurants() {
        List<PlatformEntity> restaurantEntities = platformRepository.findAll();
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
